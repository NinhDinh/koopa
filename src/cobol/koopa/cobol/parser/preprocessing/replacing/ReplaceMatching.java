package koopa.cobol.parser.preprocessing.replacing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;

public class ReplaceMatching extends ReplacingPhrase {

	private static final Logger LOGGER = Logger.getLogger("tokenising.preprocessing.replacing.matching");

	public ReplaceMatching(ReplacingPhraseOperand replacing, ReplacingPhraseOperand by) {
		super(replacing, by);
	}

	public boolean appliedTo(Source<Data> library, LinkedList<Token> newTokens) {
		boolean matchOccurred = true;
		Stack<Token> seenWhileMatching = new Stack<Token>();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Trying " + this);

		Iterator<Token> it = replacing.getTextWords().iterator();
		while (it.hasNext()) {
			final Token libraryTextWord = nextTextWord(library, seenWhileMatching);

			if (libraryTextWord == null) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("  <EOF>");

				matchOccurred = false;
				break;
			}

			// Newlines are not matched against.
			if (isNewline(libraryTextWord))
				continue;

			// Spaces are not matched against, as they are not considered text
			// words.
			if (isConsideredSingleSpace(libraryTextWord))
				continue;

			final Token textWord = it.next();
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("  TESTING " + textWord);
				LOGGER.trace("    AGAINST " + libraryTextWord);
			}

			final String text = textWord.getText();
			final String libraryText = libraryTextWord.getText();

			if (!text.equalsIgnoreCase(libraryText)) {
				matchOccurred = false;
				break;
			}
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("  => " + (matchOccurred ? "MATCH FOUND" : "NO MATCH"));

		if (matchOccurred) {
			// "When a match occurs between pseudo-text-1, text-1,
			// word-1, or literal-3 and the library text, the
			// corresponding pseudo-text-2, text-2, word-2, or
			// literal-4 is placed into the resultant text."

			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("Matched " + replacing);
				LOGGER.trace("  Replaced with " + by);
			}

			// The output should include any whitespace we skipped while
			// matching.
			if (!seenWhileMatching.isEmpty())
				for (Token token : seenWhileMatching) {
					if (isNewline(token) || isConsideredSingleSpace(token))
						newTokens.add(token);
					else
						break;
				}

			newTokens.addAll(by.getTokens());

		} else
			unshiftStack(library, seenWhileMatching);

		return matchOccurred;
	}

	@Override
	public String toString() {
		return "REPLACING MATCHING " + replacing + " BY " + by;
	}
}
