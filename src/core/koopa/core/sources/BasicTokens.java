package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.io.Reader;

import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.TagAll;
import koopa.core.sources.TokenSeparator;

public class BasicTokens {
	public static Source<Token> getNewSource(String resourceName,
			Reader reader) {
		Source<Token> source;

		// Split lines...
		source = new LineSplitter(resourceName, reader);
		// And mark everything as program text...
		source = new TagAll(source, PROGRAM_TEXT_AREA);
		// Separate the tokens...
		source = new TokenSeparator(source);

		return source;
	}
}