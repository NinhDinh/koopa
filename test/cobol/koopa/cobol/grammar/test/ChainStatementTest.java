package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ChainStatement.stage. */
public class ChainStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testChainStatement_1() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_2() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_3() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n   END-CHAIN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_4() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN \"foo\"\n   END-CHAIN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_5() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_6() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING REFERENCE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_7() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY REFERENCE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_8() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY REFERENCE \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_9() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY REFERENCE ADDRESS OF bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_10() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY REFERENCE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_11() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo USING\n     BY REFERENCE bar\n     BY REFERENCE \"bar\"\n     BY REFERENCE ADDRESS OF bar\n     BY REFERENCE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_12() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING CONTENT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_13() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY CONTENT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_14() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY CONTENT \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_15() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY CONTENT LENGTH OF bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_16() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo USING\n     BY CONTENT bar\n     BY CONTENT \"bar\"\n     BY CONTENT LENGTH OF bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_17() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING VALUE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_18() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY VALUE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_19() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY VALUE 100 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_20() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY VALUE 100 SIZE 200 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_21() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY VALUE 100 SIZE IS 200 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_22() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo\n     USING BY VALUE LENGTH OF bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_23() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo USING\n     BY VALUE bar\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE LENGTH OF bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_24() {
      ParserCombinator parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAIN foo USING\n     BY REFERENCE bar\n     BY REFERENCE \"bar\"\n     BY REFERENCE ADDRESS OF bar\n     BY REFERENCE OMITTED\n     BY CONTENT bar\n     BY CONTENT \"bar\"\n     BY CONTENT LENGTH OF bar\n     BY VALUE bar\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE LENGTH OF bar\n   END-CHAIN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}