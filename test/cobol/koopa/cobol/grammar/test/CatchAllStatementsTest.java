package koopa.cobol.grammar.test;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.test.CobolTestSource;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

public class CatchAllStatementsTest extends TestCase {

	private static CobolGrammar grammar = new CobolGrammar();

	private static final List<String> VERBS = new LinkedList<String>();
	static {
		// TODO Get these from the grammar file somehow ?
		VERBS.add("ACCEPT");
		VERBS.add("ADD");
		VERBS.add("CALL");
		VERBS.add("CANCEL");
		VERBS.add("CLOSE");
		VERBS.add("COMPUTE");
		VERBS.add("CONTINUE");
		VERBS.add("DELETE");
		VERBS.add("DISPLAY");
		VERBS.add("DIVIDE");
		VERBS.add("EVALUATE");
		VERBS.add("EXIT");
		VERBS.add("GO");
		VERBS.add("IF");
		VERBS.add("INITIALIZE");
		VERBS.add("INSPECT");
		VERBS.add("MERGE");
		VERBS.add("MOVE");
		VERBS.add("MULTIPLY");
		VERBS.add("OPEN");
		VERBS.add("PERFORM");
		VERBS.add("READ");
		VERBS.add("RELEASE");
		VERBS.add("RETURN");
		VERBS.add("REWRITE");
		VERBS.add("SEARCH");
		VERBS.add("SET");
		VERBS.add("SORT");
		VERBS.add("START");
		VERBS.add("STOP");
		VERBS.add("STRING");
		VERBS.add("SUBTRACT");
		VERBS.add("UNSTRING");
		VERBS.add("USE");
		VERBS.add("WRITE");

		VERBS.add("ENABLE");
		VERBS.add("DISABLE");
		VERBS.add("RECEIVE");
	}

	@Test
	public void testSoloVerbs() {
		for (String verb : VERBS) {
			ParserCombinator parser = grammar.statement();
			assertNotNull(parser);
			// TODO Get rid of ".".
			TestTokenizer tokenizer = new TestTokenizer(
					CobolTestSource.forSample(verb + "."));
			assertTrue(verb, parser.accepts(Parse.of(tokenizer)));
			// TODO assertNull(tokenizer.nextToken());
		}
	}

	@Test
	public void testVerbsWithStuff() {
		for (String verb : VERBS) {
			ParserCombinator parser = grammar.statement();
			assertNotNull(parser);
			// TODO Get rid of ".".
			TestTokenizer tokenizer = new TestTokenizer(
					CobolTestSource
							.forSample(verb
									+ " Thank you Mario but our Princess is in another castle ."));
			assertTrue(verb, parser.accepts(Parse.of(tokenizer)));
			// TODO assertNull(tokenizer.nextToken());
		}
	}
}
