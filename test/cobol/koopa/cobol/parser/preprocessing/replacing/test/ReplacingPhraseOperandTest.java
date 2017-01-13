package koopa.cobol.parser.preprocessing.replacing.test;

import static koopa.cobol.parser.preprocessing.replacing.ReplacingPhraseOperand.Type.LITERAL;
import static koopa.cobol.parser.preprocessing.replacing.ReplacingPhraseOperand.Type.PSEUDO;
import static koopa.cobol.parser.preprocessing.replacing.ReplacingPhraseOperand.Type.WORD;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.util.test.Util.asTokens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import koopa.cobol.parser.preprocessing.replacing.ReplaceLeading;
import koopa.cobol.parser.preprocessing.replacing.ReplaceMatching;
import koopa.cobol.parser.preprocessing.replacing.ReplaceTrailing;
import koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase;
import koopa.cobol.parser.preprocessing.replacing.ReplacingPhraseOperand;
import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.TagAll;
import koopa.core.sources.WideningSource;
import koopa.core.sources.test.HardcodedSource;

public class ReplacingPhraseOperandTest {

	@Test
	public void canMatchWord() {
		ReplacingPhrase phrase = matching(word("COBOL"), word("Hopper"));

		assertMatches(phrase, input("COBOL"));
		assertMatches(phrase, input("cobol"));

		assertRejects(phrase, input("PL/I"));
	}

	@Test
	public void canMatchStringLiteral() {
		ReplacingPhrase phrase = matching(stringLiteral("\"COBOL\""),
				stringLiteral("\"Hopper\""));

		assertMatches(phrase, input("\"COBOL\""));
		assertMatches(phrase, input("\"cobol\""));

		assertRejects(phrase, input("COBOL"));
		assertRejects(phrase, input("\"PL/I\""));
	}

	@Test
	public void canMatchPseudoTextSingleWord() {
		ReplacingPhrase phrase = matching(pseudo("=", "=", "COBOL", "=", "="),
				pseudo("=", "=", "REPLACEMENT", "TOKENS", "=", "="));

		assertMatches(phrase, input("COBOL"));
		assertMatches(phrase, input("cobol"));

		assertRejects(phrase, input("PL/I"));
	}

	@Test
	public void canMatchPseudoTextMultiWord() {
		ReplacingPhrase phrase = matching( //
				pseudo("=", "=", "GRACE", SEPARATOR, WHITESPACE, " ", "HOPPER",
						"=", "="), //
				pseudo("=", "=", "Grace", SEPARATOR, WHITESPACE, " ", "Murray",
						SEPARATOR, " ", "Hopper", "=", "="));

		assertMatches(phrase,
				input("GRACE", SEPARATOR, WHITESPACE, " ", "HOPPER"));
		assertMatches(phrase,
				input("Grace", SEPARATOR, WHITESPACE, " ", "Hopper"));

		assertRejects(phrase, input("GRACE"));
		assertRejects(phrase, input("HOPPER"));
		assertRejects(phrase,
				input("HOPPER", SEPARATOR, WHITESPACE, " ", "GRACE"));
	}

	@Test
	public void canMatchPseudoTextWithSurroundingSpaces() {
		ReplacingPhrase phrase = matching( //
				pseudo("=", "=", SEPARATOR, WHITESPACE, " ", "GRACE", SEPARATOR,
						WHITESPACE, " ", "HOPPER", SEPARATOR, WHITESPACE, " ",
						"=", "="), //
				pseudo("=", "=", "Grace", SEPARATOR, WHITESPACE, " ", "Murray",
						SEPARATOR, " ", "Hopper", "=", "="));

		assertMatches(phrase,
				input("GRACE", SEPARATOR, WHITESPACE, " ", "HOPPER"));

		assertRejects(phrase, input("GRACE"));
		assertRejects(phrase, input("HOPPER"));
		assertRejects(phrase, input("HOPPER", "GRACE"));
	}

	@Test
	public void canMatchPseudoTextWithMultiSpaces() {
		ReplacingPhrase phrase = matching(
				pseudo("=", "=", "GRACE", SEPARATOR, WHITESPACE, " ", SEPARATOR,
						WHITESPACE, " ", "HOPPER", "=", "="), //
				pseudo("=", "=", "Grace", "Murray", "Hopper", "=", "="));

		// assertMatches(phrase, input("GRACE", "HOPPER"));
		assertMatches(phrase,
				input("GRACE", SEPARATOR, WHITESPACE, " ", "HOPPER"));
		assertMatches(phrase, input("GRACE", SEPARATOR, WHITESPACE, " ",
				SEPARATOR, WHITESPACE, " ", "HOPPER"));
	}

	// Cfr. #54 COPY-REPLACING statement not interpreted
	@Test
	public void canHandleIssue54() {
		final ReplacingPhrase phrase = matching( //
				pseudo("=", "=", SEPARATOR, WHITESPACE, " ", ":", "L", ":",
						SEPARATOR, WHITESPACE, " ", "=", "="), //
				word("FOO"));

		assertMatches(phrase, input(":", "L", ":"));
	}

	@Test
	public void canReplaceStartOfWordWithSomething() {
		ReplacingPhrase phrase = leading(pseudo("=", "=", "LANG", "=", "="),
				pseudo("=", "=", "COBOL", "=", "="));

		assertMatches(phrase, input("LANG-NAME"),
				Arrays.asList(new Token[] {
						new Token("COBOL-NAME", new Position(3, 0, 3),
								new Position(10, 0, 10), PROGRAM_TEXT_AREA) }));
		assertRejects(phrase, input("LING-NAME"));
	}

	@Test
	public void canReplaceStartOfWordWithNothing() {
		ReplacingPhrase phrase = leading(pseudo("=", "=", "LANG", "=", "="),
				pseudo("=", "=", "=", "="));

		assertMatches(phrase, input("LANG-NAME"),
				Arrays.asList(
						new Token[] { new Token("-NAME", new Position(5, 0, 5),
								new Position(10, 0, 10), PROGRAM_TEXT_AREA) }));
		assertRejects(phrase, input("LING-NAME"));
	}

	@Test
	public void canReplaceEndOfWordWithSomething() {
		ReplacingPhrase phrase = trailing(pseudo("=", "=", "LANG", "=", "="),
				pseudo("=", "=", "COBOL", "=", "="));

		assertMatches(phrase, input("NAME-LANG"),
				Arrays.asList(new Token[] {
						new Token("NAME-COBOL", new Position(1, 0, 1),
								new Position(8, 0, 8), PROGRAM_TEXT_AREA) }));
		assertRejects(phrase, input("NAME-LING"));
	}

	@Test
	public void canReplaceEndOfWordWithNothing() {
		ReplacingPhrase phrase = trailing(pseudo("=", "=", "LANG", "=", "="),
				pseudo("=", "=", "=", "="));

		assertMatches(phrase, input("NAME-LANG"),
				Arrays.asList(
						new Token[] { new Token("NAME-", new Position(1, 0, 1),
								new Position(5, 0, 5), PROGRAM_TEXT_AREA) }));
		assertRejects(phrase, input("NAME-LING"));
	}

	// ------------------------------------------------------------------------

	private static void assertMatches(ReplacingPhrase phrase,
			Source<Token> library) {
		assertMatches(phrase, library, phrase.getBy().getTokens());
	}

	private static void assertMatches(ReplacingPhrase phrase,
			Source<Token> library, List<Token> expected) {

		LinkedList<Token> result = new LinkedList<Token>();
		Assert.assertTrue(phrase.appliedTo(
				new WideningSource<Data, Token>(library, Token.class), result));

		final Token next = library.next();
		Assert.assertNull("Not null: " + next, next);

		Assert.assertEquals(expected.size(), result.size());
		for (int i = 0; i < expected.size(); i++) {
			Token a = expected.get(i);
			Token b = result.get(i);
			Assert.assertEquals(a.getText(), b.getText());
			Assert.assertEquals(a.getStart(), b.getStart());
			Assert.assertEquals(a.getEnd(), b.getEnd());
			Assert.assertEquals(a.getTags(), b.getTags());
		}
	}

	private static void assertRejects(ReplacingPhrase phrase,
			Source<Token> library) {
		final Token firstToken = library.next();
		if (firstToken != null)
			library.unshift(firstToken);

		Assert.assertFalse(phrase.appliedTo(//
				new WideningSource<Data, Token>(library, Token.class),
				new LinkedList<Token>()));
		Assert.assertSame(firstToken, library.next());
	}

	private ReplacingPhraseOperand word(String word) {
		return new ReplacingPhraseOperand(WORD, asTokens(word));
	}

	private ReplacingPhraseOperand stringLiteral(String literal) {
		return new ReplacingPhraseOperand(LITERAL, asTokens(STRING, literal));
	}

	private ReplacingPhraseOperand pseudo(Object... tagsAndTokens) {
		return new ReplacingPhraseOperand(PSEUDO, asTokens(tagsAndTokens));
	}

	private static Source<Token> input(Object... tagsAndTokens) {
		return new TagAll(HardcodedSource.from(tagsAndTokens),
				PROGRAM_TEXT_AREA);
	}

	private static ReplaceMatching matching(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		return new ReplaceMatching(replacing, by);
	}

	private static ReplaceLeading leading(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		return new ReplaceLeading(replacing, by);
	}

	private static ReplaceTrailing trailing(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		return new ReplaceTrailing(replacing, by);
	}
}
