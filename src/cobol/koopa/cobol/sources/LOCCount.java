package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.END_OF_LINE;
import koopa.cobol.data.tags.ContinuationsTag;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

public class LOCCount extends BasicSource<Token> implements Source<Token> {

	private final Source<? extends Token> source;

	private int lines;
	private int code;
	private int comments;

	private boolean done = false;
	private boolean sawCode = false;
	private boolean sawComment = false;

	public LOCCount(Source<? extends Token> source) {
		assert (source != null);

		this.source = source;

		this.lines = 0;
		this.code = 0;
		this.comments = 0;
	}

	@Override
	public Token nxt1() {
		if (done)
			return null;

		Token token = source.next();

		if (token == null || token.hasTag(END_OF_LINE)) {
			lines += 1;

			if (sawCode)
				code += 1;

			if (sawComment)
				comments += 1;

			sawCode = false;
			sawComment = false;

			done = (token == null);

		} else if (token.hasTag(ContinuationsTag.LEADING_QUOTE)) {

		} else if (token.hasTag(AreaTag.COMMENT)) {
			sawComment = true;

		} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			sawCode = true;
		}

		return token;
	}

	@Override
	public void close() {
		source.close();
	}

	public int getNumberOfLines() {
		return lines;
	}

	public int getNumberOfLinesWithCode() {
		return code;
	}

	public int getNumberOfLinesWithComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "LOC { lines: " + lines + ", code: " + code + ", comments: "
				+ comments + " }";
	}
}
