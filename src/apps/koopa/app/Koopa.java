package koopa.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import koopa.app.actions.CloseFileAction;
import koopa.app.actions.ExportASTToXMLAction;
import koopa.app.actions.ExportBatchResultsToCSVAction;
import koopa.app.actions.FindAction;
import koopa.app.actions.FindAgainAction;
import koopa.app.actions.GoToLineAction;
import koopa.app.actions.OpenFileAction;
import koopa.app.actions.QueryUsingXPathAction;
import koopa.app.actions.QuitParsingAction;
import koopa.app.actions.ReloadFileAction;
import koopa.app.actions.ShowASTAction;
import koopa.app.actions.ShowGrammarAction;
import koopa.app.batchit.BatchResults;
import koopa.app.batchit.ClearResultsAction;
import koopa.app.components.copybookpaths.CopybookPathsSelector;
import koopa.app.components.detail.Detail;
import koopa.app.components.grammarview.GrammarView;
import koopa.app.components.misc.Tab;
import koopa.app.components.overview.Overview;
import koopa.app.util.Getter;
import koopa.cobol.CobolFiles;
import koopa.cobol.parser.Metrics;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.ParsingCoordinator;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.treeparsers.Tree;
import koopa.core.util.Tuple;

import org.apache.log4j.PropertyConfigurator;

public class Koopa extends JFrame implements Application, Configurable {

	private static final long serialVersionUID = 1L;

	public static void main(final String[] args) {
		final URL resource = Detail.class.getResource("/log4j.properties");
		PropertyConfigurator.configure(resource);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Koopa koopa = new Koopa();
				koopa.setVisible(true);
				if (args.length > 0)
					koopa.openFile(new File(args[0]).getAbsoluteFile());
			}
		});
	}

	private static DecimalFormat coverageFormatter = new DecimalFormat("0.0");

	private static final String MODIFIER = "::::";
	private static final String MODIFIER_KEY;
	static {
		String os = System.getProperty("os.name");
		if ("Mac OS X".equals(os))
			MODIFIER_KEY = "meta";
		else
			MODIFIER_KEY = "ctrl";
	}

	private List<ApplicationListener> listeners = new ArrayList<ApplicationListener>();

	private JMenu file = null;
	private JMenuItem open = null;
	private JMenuItem reload = null;
	private JMenuItem close = null;
	private JMenuItem quitParsing = null;
	private JMenuItem clearResults = null;
	private JMenuItem saveCSV = null;

	private JMenu parserSettings = null;
	private JMenu sourceFormat = null;
	private JRadioButtonMenuItem fixedFormat = null;
	private JRadioButtonMenuItem freeFormat = null;
	private JMenu preprocessing = null;
	private JRadioButtonMenuItem preprocessingEnabled = null;
	private JRadioButtonMenuItem preprocessingDisabled = null;
	private JMenuItem copybookPath = null;

	private JMenu navigation = null;
	private JMenuItem goToLine = null;
	private JMenuItem find = null;
	private JMenuItem findAgain = null;

	private JMenu syntaxTree = null;
	private JMenuItem showAST = null;
	private JMenuItem saveXML = null;
	private JMenuItem queryUsingXath = null;
	private JMenuItem showGrammar = null;

	private JTabbedPane tabbedPane = null;
	private Overview overview = null;

	private JFrame grammarViewDialog = null;
	private GrammarView grammarView = null;

	public Koopa() {
		super("Koopa - revision " + ApplicationSupport.getRevision());

		ApplicationSupport.configureFromProperties("koopa.properties", this);

		setupComponents();
		setupMenuBar();

		updateMenus();

		setupDragAndDropOfFiles();

		Rectangle screenSize = getGraphicsConfiguration().getBounds();
		setSize(screenSize.width - 100, screenSize.height - 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setOption(String name, String value) {
	}

	private void setupMenuBar() {
		// Be nice to mac users (like me).
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		// File operations ----------------------------------------------------

		file = new JMenu("File");

		open = new JMenuItem(new OpenFileAction("Parse ...", this,
				CobolFiles.getSwingFileFilter(false), this));

		setAccelerators(open, MODIFIER + " O");
		file.add(open);

		reload = new JMenuItem(new ReloadFileAction(this));
		setAccelerators(reload, MODIFIER + " R");
		file.add(reload);

		close = new JMenuItem(new CloseFileAction(this));
		setAccelerators(close, MODIFIER + " W", "ESCAPE");
		file.add(close);

		file.addSeparator();

		quitParsing = new JMenuItem(new QuitParsingAction(this));
		setAccelerators(quitParsing, MODIFIER + " B");
		file.add(quitParsing);

		file.addSeparator();

		clearResults = new JMenuItem(new ClearResultsAction(overview));
		file.add(clearResults);

		saveCSV = new JMenuItem(new ExportBatchResultsToCSVAction(
				new Getter<BatchResults>() {
					public BatchResults getIt() {
						return overview.getResults();
					}
				}, this));

		setAccelerators(saveCSV, MODIFIER + " E");
		file.add(saveCSV);

		bar.add(file);

		// --- Parser settings ------------------------------------------------

		parserSettings = new JMenu("Parser settings");

		sourceFormat = new JMenu("Source format");
		parserSettings.add(sourceFormat);

		final ButtonGroup group = new ButtonGroup();

		fixedFormat = new JRadioButtonMenuItem();

		AbstractAction selectFixedFormat = new AbstractAction("Fixed") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				// TODO Use a common interface for these.
				Component view = getView();
				if (view == overview) {
					overview.getParsingCoordinator().setFormat(
							SourceFormat.FIXED);
				} else {
					((Detail) view).getParsingCoordinator().setFormat(
							SourceFormat.FIXED);
				}
			}
		};

		fixedFormat.setAction(selectFixedFormat);

		fixedFormat.setSelected(true);
		group.add(fixedFormat);
		sourceFormat.add(fixedFormat);

		freeFormat = new JRadioButtonMenuItem();

		AbstractAction selectFreeFormat = new AbstractAction("Free") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				// TODO Use a common interface for these.
				Component view = getView();
				if (view == overview) {
					overview.getParsingCoordinator().setFormat(
							SourceFormat.FREE);
				} else {
					((Detail) view).getParsingCoordinator().setFormat(
							SourceFormat.FREE);
				}
			}
		};

		freeFormat.setAction(selectFreeFormat);

		group.add(freeFormat);
		sourceFormat.add(freeFormat);

		preprocessing = new JMenu("Preprocessing (ALPHA!)");
		parserSettings.add(preprocessing);

		final ButtonGroup preprocessingGroup = new ButtonGroup();
		preprocessingEnabled = new JRadioButtonMenuItem();
		preprocessingDisabled = new JRadioButtonMenuItem("Disabled");
		preprocessingGroup.add(preprocessingEnabled);
		preprocessingGroup.add(preprocessingDisabled);

		AbstractAction enablePreprocessing = new AbstractAction("Enabled") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Component view = getView();
				if (view == overview)
					overview.getParsingCoordinator().setPreprocessing(true);
				else
					((Detail) view).getParsingCoordinator().setPreprocessing(
							true);

			}
		};

		AbstractAction disablePreprocessing = new AbstractAction("Disabled") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Component view = getView();
				if (view == overview)
					overview.getParsingCoordinator().setPreprocessing(false);
				else
					((Detail) view).getParsingCoordinator().setPreprocessing(
							false);
			}
		};

		preprocessingEnabled.setAction(enablePreprocessing);
		preprocessingDisabled.setAction(disablePreprocessing);

		preprocessing.add(preprocessingEnabled);
		preprocessing.add(preprocessingDisabled);
		preprocessingDisabled.setSelected(true);

		preprocessing.addSeparator();

		copybookPath = new JMenuItem();

		AbstractAction setCopybookPath = new AbstractAction("Copybook Paths...") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				ParsingCoordinator coordinator = null;

				Component view = getView();
				if (view == overview)
					coordinator = overview.getParsingCoordinator();
				else
					coordinator = ((Detail) view).getParsingCoordinator();
				CopybookPathsSelector selector = new CopybookPathsSelector(
						Koopa.this, coordinator);
				selector.setVisible(true);
			}
		};
		copybookPath.setAction(setCopybookPath);

		preprocessing.add(copybookPath);

		bar.add(parserSettings);

		// Navigation ---------------------------------------------------------

		navigation = new JMenu("Navigation");

		goToLine = new JMenuItem(new GoToLineAction(this, this));
		setAccelerators(goToLine, MODIFIER + " L");
		navigation.add(goToLine);

		final FindAction findAction = new FindAction(this, this);
		find = new JMenuItem(findAction);
		setAccelerators(find, MODIFIER + " F");
		navigation.add(find);

		findAgain = new JMenuItem(new FindAgainAction(this, this, findAction));
		setAccelerators(findAgain, MODIFIER + " G");
		navigation.add(findAgain);

		bar.add(navigation);

		// Parse results ------------------------------------------------------

		syntaxTree = new JMenu("Syntax tree");

		showGrammar = new JMenuItem(new ShowGrammarAction(this));
		// setAccelerators(showGrammar, MODIFIER + " G");
		syntaxTree.add(showGrammar);

		syntaxTree.addSeparator();

		showAST = new JMenuItem(new ShowASTAction(this, this));
		syntaxTree.add(showAST);

		saveXML = new JMenuItem(new ExportASTToXMLAction(this, this));
		// setAccelerators(saveXML, MODIFIER + " E");
		syntaxTree.add(saveXML);

		queryUsingXath = new JMenuItem(new QueryUsingXPathAction(this, this));
		setAccelerators(queryUsingXath, MODIFIER + " D");
		syntaxTree.add(queryUsingXath);

		bar.add(syntaxTree);

		// --------------------------------------------------------------------

		setJMenuBar(bar);
	}

	private void setupComponents() {
		tabbedPane = new JTabbedPane();

		overview = new Overview(this);
		tabbedPane.addTab("Overview", overview);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateMenus();
				fireSwitchedView(getView());
			}
		});

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	private void setupDragAndDropOfFiles() {
		TransferHandler handler = new TransferHandler() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean canImport(TransferHandler.TransferSupport info) {
				return info
						.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
			}

			@Override
			public boolean importData(TransferHandler.TransferSupport info) {
				// TODO Check that Koopa isn't already doing something else...

				if (!info.isDrop())
					return false;

				if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					JOptionPane.showMessageDialog(Koopa.this,
							"Koopa doesn't accept this type of data.",
							"Sorry...", JOptionPane.ERROR_MESSAGE);
					return false;
				}

				try {
					Transferable t = info.getTransferable();

					@SuppressWarnings("unchecked")
					final List<File> data = (List<File>) t
							.getTransferData(DataFlavor.javaFileListFlavor);

					if (data != null && !data.isEmpty()) {
						new Thread(new Runnable() {
							public void run() {
								if (data.size() == 1) {
									File file = data.get(0);

									if (file.isDirectory()) {
										tabbedPane
												.setSelectedComponent(overview);
										overview.walkAndParse(file);

									} else {
										openFile(file);
									}

								} else {
									tabbedPane.setSelectedComponent(overview);
									for (File file : data)
										overview.walkAndParse(file);
								}
							}
						}).start();
					}

					return true;

				} catch (UnsupportedFlavorException e) {
					return false;

				} catch (IOException e) {
					return false;
				}
			}
		};

		this.setTransferHandler(handler);
	}

	private void updateMenus() {
		Component view = getView();

		if (view == overview) {
			boolean isParsing = overview.isParsing();
			boolean hasResults = !isParsing
					&& overview.getResults().getRowCount() > 0;

			// File menu ...
			open.setEnabled(!isParsing);
			reload.setEnabled(false);
			close.setEnabled(false);
			quitParsing.setEnabled(isParsing);
			clearResults.setEnabled(hasResults);
			saveCSV.setEnabled(hasResults);

			// Parse settings ...
			parserSettings.setEnabled(!isParsing);
			switch (overview.getParsingCoordinator().getFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			if (overview.getParsingCoordinator().isPreprocessing())
				preprocessingEnabled.setSelected(true);
			else
				preprocessingEnabled.setSelected(false);

			// Navigation ...
			navigation.setEnabled(false);
			goToLine.setEnabled(false);
			find.setEnabled(false);
			findAgain.setEnabled(false);

			// Syntax tree ...
			showAST.setEnabled(false);
			saveXML.setEnabled(false);
			queryUsingXath.setEnabled(false);

		} else {
			Detail detail = (Detail) view;

			boolean isParsing = overview.isParsing();
			boolean canDoExtraActions = !isParsing && !detail.isParsing();

			// File menu ...
			open.setEnabled(canDoExtraActions);
			reload.setEnabled(canDoExtraActions);
			close.setEnabled(canDoExtraActions);
			quitParsing.setEnabled(isParsing);
			clearResults.setEnabled(false);
			saveCSV.setEnabled(false);

			// Parse settings ...
			switch (detail.getParsingCoordinator().getFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			if (detail.getParsingCoordinator().isPreprocessing())
				preprocessingEnabled.setSelected(true);
			else
				preprocessingEnabled.setSelected(false);

			// Navigation ...
			navigation.setEnabled(true);
			goToLine.setEnabled(true);
			find.setEnabled(true);
			findAgain.setEnabled(true);

			// Syntax tree ...
			boolean hasSyntaxTree = detail.hasSyntaxTree();
			showAST.setEnabled(hasSyntaxTree);
			saveXML.setEnabled(hasSyntaxTree);
			queryUsingXath.setEnabled(hasSyntaxTree);
		}
	}

	public void openFile(File file) {
		Component view = getView();

		if (overview == view) {
			openFile(file, overview.getParsingCoordinator(), null);

		} else {
			Detail detail = (Detail) view;
			openFile(file, detail.getParsingCoordinator(), null);
		}
	}

	public void openFile(File file, ParsingCoordinator parsingCoordinator) {
		openFile(file, parsingCoordinator, null);
	}

	public void openFile(File file, ParsingCoordinator parsingCoordinator,
			Tuple<Token, String> selectedToken) {

		if (file.isDirectory()) {
			overview.walkAndParse(file);
			return;
		}

		// TODO Check if there already exists a tab for the given file. In that
		// case do a reload instead.

		final Detail detail = new Detail(this, file, parsingCoordinator);
		overview.addParseResults(detail.getParseResults());

		String title = getTitleForDetail(detail);

		Tab tab = new Tab(title, this, detail);

		tabbedPane.addTab(title, detail);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(detail), tab);

		if (selectedToken != null)
			detail.selectDetail(selectedToken);

		tabbedPane.setSelectedComponent(detail);
	}

	private String getTitleForDetail(Detail detail) {
		final ParseResults parseResults = detail.getParseResults();

		float coverage = Metrics.getCoverage(parseResults);
		String title = detail.getFile().getName();
		if (coverage < 100)
			title += " (" + coverageFormatter.format(coverage) + "%)";

		return title;
	}

	public void resultsWereCleared() {
		updateMenus();
	}

	public void walkingAndParsing() {
		updateMenus();
	}

	public void doneWalkingAndParsing() {
		updateMenus();
	}

	public void reloadFile() {
		Component view = getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			detail.reloadFile();

			Tab tab = (Tab) tabbedPane.getTabComponentAt(tabbedPane
					.indexOfComponent(detail));
			tab.setTitle(getTitleForDetail(detail));

			updateMenus();
			fireUpdatedView(view);
		}
	}

	public void scrollTo(int position) {
		Component view = getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			detail.scrollTo(position);
		}
	}

	public void addApplicationListener(ApplicationListener listener) {
		listeners.add(listener);
	}

	private void fireSwitchedView(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.switchedView(view);
		}
	}

	private void fireUpdatedView(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.updatedView(view);
		}
	}

	private void fireClosedDetail(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.closedDetail(view);
		}
	}

	public Tree getSyntaxTree() {
		final Component view = getView();
		if (view == overview)
			return null;
		else
			return ((Detail) view).getParseResults().getTree();
	}

	public Component getView() {
		return tabbedPane.getSelectedComponent();
	}

	public void closeView(Component component) {
		if (component == overview)
			return;

		int index = tabbedPane.indexOfComponent(component);
		tabbedPane.removeTabAt(index);

		fireClosedDetail(component);
		updateMenus();
	}

	public void closeView() {
		closeView(getView());
	}

	public void showGrammarRules() {
		showGrammarRule(null);
	}

	public void showGrammarRule(String name) {
		if (grammarView == null) {
			grammarView = new GrammarView("/koopa/cobol/grammar/Cobol.kg");
			grammarViewDialog = ApplicationSupport.inFrame("Cobol grammar",
					grammarView);
		}

		grammarViewDialog.setVisible(true);
		grammarView.showRule(name);
	}

	private void setAccelerators(JMenuItem item, String keyStrokeDefinition,
			String... alternateKeyStrokesDefinitions) {

		KeyStroke keystroke = KeyStroke.getKeyStroke(keyStrokeDefinition
				.replaceAll(MODIFIER, MODIFIER_KEY));
		item.setAccelerator(keystroke);

		if (alternateKeyStrokesDefinitions != null
				&& alternateKeyStrokesDefinitions.length > 0) {
			InputMap im = item.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			final Object actionMapKey = im.get(keystroke);

			for (String alternateKeyStrokeDefinition : alternateKeyStrokesDefinitions) {
				KeyStroke alternateKeystroke = KeyStroke
						.getKeyStroke(alternateKeyStrokeDefinition.replaceAll(
								MODIFIER, MODIFIER_KEY));
				im.put(alternateKeystroke, actionMapKey);
			}
		}
	}

	public void quitParsing() {
		overview.quitParsing();
	}
}
