tree grammar StageGenerator;

options {
  tokenVocab = Stage;
  language = Java;
  output = template;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.core.grammars.test.generator;
  
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
}

@members {
  private int count = 0;
}


stage [String name]
  : { List<StringTemplate> tests = new LinkedList<StringTemplate>(); }
  
    ^(STAGE p=pack g=grammah 
      (t=testsForGrammarRule
        {tests.addAll($t.tests);}
      )*
    )
  
    -> stage(
      name = {name},
      date = {new Date()},
      package = {p},
      grammah = {g},
      test = {tests}
    )
  ;
  
pack
  : ^(PACKAGE IDENTIFIER)
  
    -> {%{((CommonTree) $IDENTIFIER).getText()}}
  ;

grammah
  : ^(GRAMMAR IDENTIFIER)
  
    -> {%{((CommonTree) $IDENTIFIER).getText()}}
  ;

testsForGrammarRule returns [List<StringTemplate> tests = new LinkedList<StringTemplate>()]
  : ^(TARGET i=IDENTIFIER
       ( t=test[((CommonTree) $i).getText()]
         { $testsForGrammarRule.tests.add($t.st); }
       )*
    )
  ;
  
test [String target]
  : ^(TEST
      { boolean accept = true;
        boolean free = true;
        String data = ""; }
      
      ( ACCEPT
      | REJECT { accept = false; }
      )
      
      ( FREE_DATA
        { data = ((CommonTree) $FREE_DATA).getText(); }
      
      | FIXED_DATA
        { data = ((CommonTree) $FIXED_DATA).getText();
          free = false;
        }
      )
    )
    
    { String name = target.substring(1);
      name = Character.toUpperCase(target.charAt(0)) + name;
    }
    
    { data = data.substring(1, data.length() - 1);
      // data = data.replaceAll("\u2022", "\\\\u2022");
      data = data.replaceAll("\n", "\\\\n");
      data = data.replaceAll("\"", "\\\\\"");
    }
    
    -> {accept}? accept(
      name = {name},
      number = {++count},
      target = {target},
      token = {data},
      format = {free}
    )
    
    -> reject(
      name = {name},
      number = {++count},
      target = {target},
      token = {data},
      format = {free}
    )
  ;
