package koopa.core.parsers.combinators;

import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator} once, but will only accept its match if it was
 * non-empty.
 */
public class NotEmpty extends UnaryParserDecorator {

	public NotEmpty(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");

		final Token initialToken = stream.peek();
		if (initialToken == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, at end");
			return false;
		}

		final boolean accepts = parser.accepts(parse);
		if (!accepts) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no");
			return false;
		}

		final Token finalToken = stream.peek();
		if (finalToken == initialToken) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.dedent(toString() + " : no, no tokens consumed");
			return false;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(toString() + " : yes");

		return true;
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "%notEmpty " + parser;
	}
}