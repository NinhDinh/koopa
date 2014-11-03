package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.test.TestTokenizer;
import koopa.core.parsers.Parser;

import org.junit.Test;

/** This code was generated from IfStatement.stage. */
public class IfStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

    @Test
    public void testIfStatement_1() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD \n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_2() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_3() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_4() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_5() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY 'GOOD'\n     DISPLAY BETTER\n     DISPLAY BEST\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_6() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_7() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_8() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 \n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_9() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_10() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_11() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_12() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_13() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_14() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_15() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_16() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_17() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     NEXT SENTENCE\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_18() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2\n     NEXT SENTENCE\n   ELSE\n     DISPLAY BAD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_19() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 AND 2 > 1\n       DISPLAY GOOD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_20() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF 1 < 2 AND 2 > 1 AND V-ARIABLE = 0\n       DISPLAY GOOD\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_21() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF V-ARIABLE = 2 OR = 3\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_22() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF ( V-ARIABLE = 2 OR = 3 ) THEN\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_23() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF ( V-ARIABLE = 2 OR = 3 ) AND V-ARIABLE NOT = 3\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_24() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF V-ARIABLE NOT = 3 AND ( V-ARIABLE = 2 OR = 3 )\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_25() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF B GREATER THAN C OR EQUAL TO A OR 42 OR C - 1 THEN\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_26() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF ZERO - A IS NEGATIVE THEN\n       DISPLAY PERFECT\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_27() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IF SMALLEST-VALU GREATER THAN SMALL-VALU\n      AND IS NOT LESS THAN EVEN-SMALLER OR SMALLER-VALU\n       DISPLAY FAIL\n   END-IF ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}