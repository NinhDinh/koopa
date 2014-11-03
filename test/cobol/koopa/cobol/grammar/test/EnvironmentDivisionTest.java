package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.test.TestTokenizer;
import koopa.core.parsers.Parser;

import org.junit.Test;

/** This code was generated from EnvironmentDivision.stage. */
public class EnvironmentDivisionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

    @Test
    public void testEnvironmentDivision_1() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_2() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES .\n   DECIMAL-POINT IS COMMA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_3() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES . \n   DECIMAL-POINT COMMA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_4() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CONFIGURATION SECTION .\n   SPECIAL-NAMES . \n   DECIMAL-POINT COMMA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_5() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectSection_6() {
      Parser parser = grammar.objectSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OBJECT SECTION .\n     CLASS-CONTROL .\n       olesup is class \"olesup\"\n       wordapp is class \"$OLE$word.application\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectSection_7() {
      Parser parser = grammar.objectSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CLASS-CONTROL .\n     olesup is class \"olesup\"\n     wordapp is class \"$OLE$word.application\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}