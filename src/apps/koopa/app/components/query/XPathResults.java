package koopa.app.components.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Position;
import koopa.core.trees.antlr.CommonKoopaToken;
import koopa.core.trees.antlr.jaxen.ANTLRTreeAttribute;
import koopa.core.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class XPathResults extends AbstractTableModel {

	public static final int TYPE_COLUMN = 0;
	public static final int TEXT_COLUMN = 1;
	public static final int LINE_COLUMN = 2;
	public static final int COLUMN_COLUMN = 3;

	private List<?> results = null;
	private List<XPathResultType> types = null;
	private List<Position> positions = null;

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN:
			return "Type";

		case TEXT_COLUMN:
			return "Text";

		case LINE_COLUMN:
			return "Line";

		case COLUMN_COLUMN:
			return "Column";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		return results == null ? 0 : results.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN:
			return this.types.get(rowIndex);

		case TEXT_COLUMN:
			return this.results.get(rowIndex).toString();

		case LINE_COLUMN: {
			final Position position = this.positions.get(rowIndex);
			return position != null ? position.getLinenumber() : null;
		}

		case COLUMN_COLUMN: {
			final Position position = this.positions.get(rowIndex);
			return position != null ? position.getPositionInLine() : null;
		}

		default:
			return true;
		}
	}

	public void setResults(List<?> results) {
		this.results = results;

		if (results == null)
			results = Collections.EMPTY_LIST;

		this.types = new ArrayList<XPathResultType>(results.size());
		this.positions = new ArrayList<Position>(results.size());

		for (Object value : results) {
			if (value instanceof CommonTree) {
				final CommonTree tree = (CommonTree) value;
				final Data token = ((CommonKoopaToken) tree.getToken())
						.getKoopaData();

				if (token instanceof Marker) {
					this.types.add(XPathResultType.NODE);

				} else {
					this.types.add(XPathResultType.TOKEN);
				}

				this.positions.add(ANTLR.getStart(tree));

			} else if (value instanceof ANTLRTreeAttribute) {
				this.types.add(XPathResultType.ATTRIBUTE);
				this.positions.add(null);

			} else {
				this.types.add(XPathResultType.OTHER);
				this.positions.add(null);
			}
		}

		fireTableDataChanged();
	}

	public int getPositionInFile(int row) {
		final Position position = this.positions.get(row);
		return position != null ? position.getPositionInFile() : -1;
	}
}
