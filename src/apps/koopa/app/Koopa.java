package koopa.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.PropertyConfigurator;

import koopa.app.cli.CommandLineOptions;
import koopa.app.components.detail.Detail;
import koopa.app.components.grammarview.GrammarView;
import koopa.app.components.overview.Overview;
import koopa.app.components.progress.ProgressDialog;
import koopa.app.debug.Debug;
import koopa.app.menus.FileMenu;
import koopa.app.menus.HelpMenu;
import koopa.app.menus.LoggingMenu;
import koopa.app.menus.NavigationMenu;
import koopa.app.menus.ParserSettingsMenu;
import koopa.app.menus.SyntaxTreeMenu;
import koopa.cobol.CobolProject;
import koopa.cobol.parser.Metrics;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.util.CopybookPaths;
import koopa.core.data.Token;
import koopa.core.trees.Tree;
import koopa.core.util.TabStops;
import koopa.core.util.Tuple;

public class Koopa extends JFrame implements Application {

	private static final long serialVersionUID = 1L;

	public static void main(final String[] args) {
		final URL resource = Detail.class.getResource("/log4j.properties");
		PropertyConfigurator.configure(resource);

		final CommandLineOptions options;
		try {
			options = new CommandLineOptions(args);

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			return;
		}

		final List<String> other = options.getOther();
		if (other.size() > 1) {
			System.err.println(options.usage());
			return;
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Koopa koopa = new Koopa();
				koopa.setSourceFormat(options.getFormat());
				koopa.setPreprocessing(options.isPreprocess());
				koopa.setCopybookPaths(options.getCopybookPaths());
				koopa.setTabLength(options.getTabLength());
				koopa.setTabStops(options.getTabStops());
				koopa.setVisible(true);
				if (other.size() == 1)
					koopa.openFile(new File(other.get(0)).getAbsoluteFile());
			}
		});
	}

	private static DecimalFormat coverageFormatter = new DecimalFormat("0.0");

	private List<ApplicationListener> listeners = new ArrayList<ApplicationListener>();

	private FileMenu fileMenu = null;
	private ParserSettingsMenu parserSettingsMenu = null;
	private NavigationMenu navigationMenu = null;
	private SyntaxTreeMenu syntaxTreeMenu = null;
	private HelpMenu helpMenu = null;

	private JTabbedPane tabbedPane = null;

	private Overview overview = null;

	private JFrame grammarViewDialog = null;
	private GrammarView grammarView = null;

	public Koopa() {
		super("Koopa - revision " + ApplicationSupport.getRevision());

		setupComponents();
		setupMenuBar();

		updateMenus();

		// setupDragAndDropOfFiles();

		Rectangle screenSize = getGraphicsConfiguration().getBounds();
		setSize(screenSize.width - 100, screenSize.height - 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setupMenuBar() {
		// Be nice to mac users (like me).
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		fileMenu = new FileMenu(this);
		bar.add(fileMenu);

		parserSettingsMenu = new ParserSettingsMenu(this);
		bar.add(parserSettingsMenu);

		navigationMenu = new NavigationMenu(this);
		bar.add(navigationMenu);

		syntaxTreeMenu = new SyntaxTreeMenu(this);
		bar.add(syntaxTreeMenu);

		LoggingMenu loggingMenu = new LoggingMenu();
		bar.add(loggingMenu);

		helpMenu = new HelpMenu(this);
		bar.add(helpMenu);

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

	/*
	 * private void setupDragAndDropOfFiles() { TransferHandler handler = new
	 * TransferHandler() {
	 * 
	 * private static final long serialVersionUID = 1L;
	 * 
	 * @Override public boolean canImport(TransferHandler.TransferSupport info)
	 * { return info .isDataFlavorSupported(DataFlavor.javaFileListFlavor); }
	 * 
	 * @Override public boolean importData(TransferHandler.TransferSupport info)
	 * { // TODO Check that Koopa isn't already doing something else...
	 * 
	 * if (!info.isDrop()) return false;
	 * 
	 * if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
	 * JOptionPane.showMessageDialog(Koopa.this,
	 * "Koopa doesn't accept this type of data.", "Sorry...",
	 * JOptionPane.ERROR_MESSAGE); return false; }
	 * 
	 * try { Transferable t = info.getTransferable();
	 * 
	 * @SuppressWarnings("unchecked") final List<File> data = (List<File>) t
	 * .getTransferData(DataFlavor.javaFileListFlavor);
	 * 
	 * if (data != null && !data.isEmpty()) { new Thread(new Runnable() { public
	 * void run() { if (data.size() == 1) { File fileMenu = data.get(0);
	 * 
	 * if (fileMenu.isDirectory()) { tabbedPane .setSelectedComponent(overview);
	 * overview.walkAndParse(fileMenu);
	 * 
	 * } else { openFile(fileMenu); }
	 * 
	 * } else { tabbedPane.setSelectedComponent(overview); for (File fileMenu :
	 * data) overview.walkAndParse(fileMenu); } } }).start(); }
	 * 
	 * return true;
	 * 
	 * } catch (UnsupportedFlavorException e) { return false;
	 * 
	 * } catch (IOException e) { return false; } } };
	 * 
	 * this.setTransferHandler(handler); }
	 */

	private void updateMenus() {
		fileMenu.update();
		parserSettingsMenu.update();
		navigationMenu.update();
		syntaxTreeMenu.update();
		helpMenu.update();
	}

	public void openFile(File file) {
		openFile(file, getCobolParserFactory(), null);
	}

	public void openFile(File file, CobolParserFactory factory) {
		openFile(file, factory, null);
	}

	public void openFile(File file, CobolParserFactory factory,
			Tuple<Token, String> selectedToken) {

		if (file.isDirectory()) {
			overview.walkAndParse(file);
			return;
		}

		// TODO Check if there already exists a tab for the given fileMenu. In
		// that case do a reload instead.

		final ProgressDialog progress = new ProgressDialog(getFrame(),
				"Parsing " + file + "...");
		progress.setMessage("Parsing...");
		progress.setVisible(true);

		final Detail detail = new Detail(this, file, factory);
		overview.addParseResults(detail.getParseResults());

		String title = getTitleForDetail(detail);

		tabbedPane.addTab(title, detail);

		if (selectedToken != null)
			detail.selectDetail(selectedToken);

		tabbedPane.setSelectedComponent(detail);

		progress.setVisible(false);
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

			// Tab tab = (Tab) tabbedPane.getTabComponentAt(tabbedPane
			// .indexOfComponent(detail));
			// tab.setTitle(getTitleForDetail(detail));
			tabbedPane.setTitleAt(tabbedPane.indexOfComponent(detail),
					getTitleForDetail(detail));

			updateMenus();
			fireUpdatedView(view);

		} else if (view instanceof Debug) {
			((Debug) view).reload();

			updateMenus();
			fireUpdatedView(view);
		}
	}

	public void scrollTo(Token token) {
		Component view = getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			detail.scrollToToken(token);
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
			return ((Detail) view).getTree();
	}

	public Component getView() {
		return tabbedPane.getSelectedComponent();
	}

	public CobolParserFactory getCobolParserFactory() {
		final Component view = getView();
		if (view instanceof HoldingCobolParserFactory)
			return ((HoldingCobolParserFactory) view).getCobolParserFactory();
		else
			return null;
	}

	public void closeView(Component component) {
		if (component == overview)
			return;

		int index = tabbedPane.indexOfComponent(component);
		tabbedPane.removeTabAt(index);

		fireClosedDetail(component);
		updateMenus();

		if (component instanceof Detail)
			((Detail) component).close();
		else if (component instanceof Debug)
			((Debug) component).close();
	}

	public void closeView() {
		closeView(getView());
	}

	public void swapView(Component oldView, Component newView) {
		if (oldView == overview)
			return;

		int index = tabbedPane.indexOfComponent(oldView);
		tabbedPane.setComponentAt(index, newView);

		if (oldView instanceof Detail)
			fireClosedDetail((Detail) oldView);

		updateMenus();

		if (oldView instanceof Detail)
			((Detail) oldView).close();
		else if (oldView instanceof Debug)
			((Debug) oldView).close();
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

	public void quitParsing() {
		overview.quitParsing();
	}

	public void setCopybookPaths(List<String> copybookPaths) {
		final CobolProject project = overview.getCobolParserFactory()
				.getProject();

		if (project instanceof CopybookPaths)
			for (String path : copybookPaths)
				((CopybookPaths) project).addCopybookPath(new File(path));

		updateMenus();
	}

	public void setPreprocessing(boolean preprocessing) {
		overview.getCobolParserFactory().getProject()
				.setDefaultPreprocessing(preprocessing);
		updateMenus();
	}

	public void setSourceFormat(SourceFormat format) {
		overview.getCobolParserFactory().getProject().setDefaultFormat(format);
		updateMenus();
	}

	public void setTabLength(int tabLength) {
		overview.getCobolParserFactory().getProject().setDefaultTabLength(tabLength);
		updateMenus();
	}
	
	public void setTabStops(TabStops tabStops) {
		overview.getCobolParserFactory().getProject().setDefaultTabStops(tabStops);
		updateMenus();
	}

	public Overview getOverview() {
		return overview;
	}

	public JFrame getFrame() {
		return this;
	}
}
