package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from CancelStatement.stage. */
public class CancelStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCancelStatement_1() {
      ParserCombinator parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CANCEL MY-SUB-PROGRAM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_2() {
      ParserCombinator parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CANCEL \"MY-SUB-PROGRAM\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_3() {
      ParserCombinator parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CANCEL 42 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_4() {
      ParserCombinator parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CANCEL 42.0 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_5() {
      ParserCombinator parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CANCEL MY-SUB-PROGRAM \"MY-SUB-PROGRAM\" \"MY-OTHER-SUBPROGRAM\" MY-OTHER-SUBPROGRAM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}