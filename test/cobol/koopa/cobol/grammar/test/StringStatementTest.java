package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from StringStatement.stage. */
public class StringStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testStringStatement_1() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_2() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT WITH POINTER MY-POINTER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_3() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT WITH POINTER MY-POINTER\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_4() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_5() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_6() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\"\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_7() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_8() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\"\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_9() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_10() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_11() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_12() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_13() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_14() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_15() {
      ParserCombinator parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" STRING\n      'ABCD001. CALL TO T456 FAILED. STATUS= '\n      T6O4-TRANS-STATUS(1,2) \n      ' '  \n     DELIMITED BY SIZE INTO P122-TEXT\n   END-STRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}