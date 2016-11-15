package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;
import koopa.cobol.parser.Coordinated;
import koopa.cobol.sources.SourceFormat;

public class SetSourceFormatAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private final Application application;
	private final SourceFormat format;

	public SetSourceFormatAction(Application application, String label,
			SourceFormat format) {
		super(label);
		this.application = application;
		this.format = format;
	}

	public void actionPerformed(ActionEvent ae) {
		final Coordinated view = application.getCoordinatedView();
		view.getParsingCoordinator().setFormat(format);
	}
}
