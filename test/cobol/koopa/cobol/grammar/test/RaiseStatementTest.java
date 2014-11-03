package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.test.TestTokenizer;
import koopa.core.parsers.Parser;

import org.junit.Test;

/** This code was generated from RaiseStatement.stage. */
public class RaiseStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

    @Test
    public void testRaiseStatement_1() {
      Parser parser = grammar.raiseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RAISE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRaiseStatement_2() {
      Parser parser = grammar.raiseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RAISE foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}