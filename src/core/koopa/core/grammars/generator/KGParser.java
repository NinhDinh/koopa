// $ANTLR 3.5.2 src/core/koopa/core/grammars/generator/KG.g

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class KGParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", "DOT", 
		"EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", "LITERAL", 
		"LOCALS", "META", "NAMED", "NATIVE_CODE", "NEWLINE", "NOSKIP", "NOT", 
		"NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", "PIPE", 
		"PLUS", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", "STAR", "TAG", "TREE", 
		"WHITESPACE", "WITH", "'def'", "'end'", "'extends'", "'grammar'", "'returns'", 
		"'tree'"
	};
	public static final int EOF=-1;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int ACT=4;
	public static final int ANY=5;
	public static final int ARROW=6;
	public static final int ASSIGN=7;
	public static final int BANG=8;
	public static final int BODY=9;
	public static final int BY=10;
	public static final int CASE=11;
	public static final int CHOICE=12;
	public static final int CLOSE_BRACKET=13;
	public static final int CLOSE_PAREN=14;
	public static final int COMMA=15;
	public static final int COMMENT=16;
	public static final int DECLARATION=17;
	public static final int DIGIT=18;
	public static final int DISPATCHED=19;
	public static final int DOLLAR=20;
	public static final int DOT=21;
	public static final int EQUALS=22;
	public static final int EXTENDING=23;
	public static final int GRAMMAR=24;
	public static final int IDENTIFIER=25;
	public static final int LETTER=26;
	public static final int LIMIT=27;
	public static final int LITERAL=28;
	public static final int LOCALS=29;
	public static final int META=30;
	public static final int NAMED=31;
	public static final int NATIVE_CODE=32;
	public static final int NEWLINE=33;
	public static final int NOSKIP=34;
	public static final int NOT=35;
	public static final int NUMBER=36;
	public static final int OPEN_BRACKET=37;
	public static final int OPEN_PAREN=38;
	public static final int OPTIONAL=39;
	public static final int PERMUTED=40;
	public static final int PIPE=41;
	public static final int PLUS=42;
	public static final int RETURNS=43;
	public static final int RULE=44;
	public static final int SEQUENCE=45;
	public static final int SKIP_TO=46;
	public static final int STAR=47;
	public static final int TAG=48;
	public static final int TREE=49;
	public static final int WHITESPACE=50;
	public static final int WITH=51;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public KGParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public KGParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return KGParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KG.g"; }


	  //private boolean verifyNativeCode(Token code) {
	  //  return JavaGrammarUtil.isValidJava(code.getText());
	  //}


	public static class koopa_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "koopa"
	// src/core/koopa/core/grammars/generator/KG.g:43:1: koopa : meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) ;
	public final KGParser.koopa_return koopa() throws RecognitionException {
		KGParser.koopa_return retval = new KGParser.koopa_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope meta1 =null;
		ParserRuleReturnScope rule2 =null;

		CommonTree EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_meta=new RewriteRuleSubtreeStream(adaptor,"rule meta");
		RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:44:3: ( meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) )
			// src/core/koopa/core/grammars/generator/KG.g:44:5: meta ( rule )* EOF
			{
			pushFollow(FOLLOW_meta_in_koopa146);
			meta1=meta();
			state._fsp--;

			stream_meta.add(meta1.getTree());
			// src/core/koopa/core/grammars/generator/KG.g:46:5: ( rule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==52) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:46:5: rule
					{
					pushFollow(FOLLOW_rule_in_koopa155);
					rule2=rule();
					state._fsp--;

					stream_rule.add(rule2.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_koopa158);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: meta, rule
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 48:5: -> ^( GRAMMAR meta ( rule )* )
			{
				// src/core/koopa/core/grammars/generator/KG.g:48:8: ^( GRAMMAR meta ( rule )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);
				adaptor.addChild(root_1, stream_meta.nextTree());
				// src/core/koopa/core/grammars/generator/KG.g:48:23: ( rule )*
				while ( stream_rule.hasNext() ) {
					adaptor.addChild(root_1, stream_rule.nextTree());
				}
				stream_rule.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "koopa"


	public static class meta_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "meta"
	// src/core/koopa/core/grammars/generator/KG.g:51:1: meta : (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) ;
	public final KGParser.meta_return meta() throws RecognitionException {
		KGParser.meta_return retval = new KGParser.meta_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token n=null;
		Token s=null;
		Token string_literal4=null;
		Token string_literal5=null;
		Token DOT6=null;

		CommonTree t_tree=null;
		CommonTree n_tree=null;
		CommonTree s_tree=null;
		CommonTree string_literal4_tree=null;
		CommonTree string_literal5_tree=null;
		CommonTree DOT6_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:52:3: ( (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) )
			// src/core/koopa/core/grammars/generator/KG.g:52:5: (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT
			{
			// src/core/koopa/core/grammars/generator/KG.g:52:5: (t= 'tree' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==57) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:52:6: t= 'tree'
					{
					t=(Token)match(input,57,FOLLOW_57_in_meta192);  
					stream_57.add(t);

					}
					break;

			}

			string_literal4=(Token)match(input,55,FOLLOW_55_in_meta196);  
			stream_55.add(string_literal4);

			n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta200);  
			stream_IDENTIFIER.add(n);

			// src/core/koopa/core/grammars/generator/KG.g:53:5: ( 'extends' s= IDENTIFIER )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==54) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:53:6: 'extends' s= IDENTIFIER
					{
					string_literal5=(Token)match(input,54,FOLLOW_54_in_meta207);  
					stream_54.add(string_literal5);

					s=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta211);  
					stream_IDENTIFIER.add(s);

					}
					break;

			}

			DOT6=(Token)match(input,DOT,FOLLOW_DOT_in_meta219);  
			stream_DOT.add(DOT6);

			// AST REWRITE
			// elements: n, n, n, s, n, s
			// token labels: s, n
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
			RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 56:5: -> { t == null && s == null }? ^( META ^( NAMED $n) )
			if ( t == null && s == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:56:36: ^( META ^( NAMED $n) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				// src/core/koopa/core/grammars/generator/KG.g:56:43: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 57:5: -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) )
			if ( t == null && s != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:57:36: ^( META ^( NAMED $n) ^( EXTENDING $s) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				// src/core/koopa/core/grammars/generator/KG.g:57:43: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// src/core/koopa/core/grammars/generator/KG.g:57:55: ^( EXTENDING $s)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDING, "EXTENDING"), root_2);
				adaptor.addChild(root_2, stream_s.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 58:5: -> { t != null && s == null }? ^( META TREE ^( NAMED $n) )
			if ( t != null && s == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:58:36: ^( META TREE ^( NAMED $n) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
				// src/core/koopa/core/grammars/generator/KG.g:58:48: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 59:5: -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
			{
				// src/core/koopa/core/grammars/generator/KG.g:59:8: ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
				// src/core/koopa/core/grammars/generator/KG.g:59:20: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// src/core/koopa/core/grammars/generator/KG.g:59:32: ^( EXTENDING $s)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDING, "EXTENDING"), root_2);
				adaptor.addChild(root_2, stream_s.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "meta"


	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// src/core/koopa/core/grammars/generator/KG.g:62:1: rule : 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) ;
	public final KGParser.rule_return rule() throws RecognitionException {
		KGParser.rule_return retval = new KGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token r=null;
		Token string_literal7=null;
		Token OPEN_PAREN8=null;
		Token CLOSE_PAREN9=null;
		Token string_literal10=null;
		Token EQUALS11=null;
		Token string_literal13=null;
		ParserRuleReturnScope l =null;
		ParserRuleReturnScope sequence12 =null;

		CommonTree i_tree=null;
		CommonTree r_tree=null;
		CommonTree string_literal7_tree=null;
		CommonTree OPEN_PAREN8_tree=null;
		CommonTree CLOSE_PAREN9_tree=null;
		CommonTree string_literal10_tree=null;
		CommonTree EQUALS11_tree=null;
		CommonTree string_literal13_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
		RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
		RewriteRuleSubtreeStream stream_locals=new RewriteRuleSubtreeStream(adaptor,"rule locals");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:63:3: ( 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) )
			// src/core/koopa/core/grammars/generator/KG.g:63:5: 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end'
			{
			string_literal7=(Token)match(input,52,FOLLOW_52_in_rule329);  
			stream_52.add(string_literal7);

			i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule333);  
			stream_IDENTIFIER.add(i);

			// src/core/koopa/core/grammars/generator/KG.g:64:7: ( OPEN_PAREN l= locals CLOSE_PAREN )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==OPEN_PAREN) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:64:8: OPEN_PAREN l= locals CLOSE_PAREN
					{
					OPEN_PAREN8=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_rule342);  
					stream_OPEN_PAREN.add(OPEN_PAREN8);

					pushFollow(FOLLOW_locals_in_rule346);
					l=locals();
					state._fsp--;

					stream_locals.add(l.getTree());
					CLOSE_PAREN9=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_rule348);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN9);

					}
					break;

			}

			// src/core/koopa/core/grammars/generator/KG.g:65:7: ( 'returns' r= IDENTIFIER )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==56) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:65:8: 'returns' r= IDENTIFIER
					{
					string_literal10=(Token)match(input,56,FOLLOW_56_in_rule359);  
					stream_56.add(string_literal10);

					r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule363);  
					stream_IDENTIFIER.add(r);

					}
					break;

			}

			EQUALS11=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_rule367);  
			stream_EQUALS.add(EQUALS11);

			pushFollow(FOLLOW_sequence_in_rule378);
			sequence12=sequence();
			state._fsp--;

			stream_sequence.add(sequence12.getTree());
			string_literal13=(Token)match(input,53,FOLLOW_53_in_rule387);  
			stream_53.add(string_literal13);

			// AST REWRITE
			// elements: r, locals, i, sequence, sequence, locals, i, r, i, sequence, i, sequence
			// token labels: r, i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 71:5: -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence )
			if ( l != null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:71:36: ^( RULE $i locals ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				// src/core/koopa/core/grammars/generator/KG.g:71:53: ^( RETURNS $r)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURNS, "RETURNS"), root_2);
				adaptor.addChild(root_2, stream_r.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 72:5: -> { l != null && r == null }? ^( RULE $i locals sequence )
			if ( l != null && r == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:72:36: ^( RULE $i locals sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 73:5: -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence )
			if ( l == null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:73:36: ^( RULE $i ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				// src/core/koopa/core/grammars/generator/KG.g:73:46: ^( RETURNS $r)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURNS, "RETURNS"), root_2);
				adaptor.addChild(root_2, stream_r.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 74:5: -> ^( RULE $i sequence )
			{
				// src/core/koopa/core/grammars/generator/KG.g:74:8: ^( RULE $i sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class locals_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "locals"
	// src/core/koopa/core/grammars/generator/KG.g:77:1: locals : declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) ;
	public final KGParser.locals_return locals() throws RecognitionException {
		KGParser.locals_return retval = new KGParser.locals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA15=null;
		ParserRuleReturnScope declaration14 =null;
		ParserRuleReturnScope declaration16 =null;

		CommonTree COMMA15_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:78:3: ( declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) )
			// src/core/koopa/core/grammars/generator/KG.g:78:5: declaration ( COMMA declaration )*
			{
			pushFollow(FOLLOW_declaration_in_locals485);
			declaration14=declaration();
			state._fsp--;

			stream_declaration.add(declaration14.getTree());
			// src/core/koopa/core/grammars/generator/KG.g:78:17: ( COMMA declaration )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMA) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:78:18: COMMA declaration
					{
					COMMA15=(Token)match(input,COMMA,FOLLOW_COMMA_in_locals488);  
					stream_COMMA.add(COMMA15);

					pushFollow(FOLLOW_declaration_in_locals490);
					declaration16=declaration();
					state._fsp--;

					stream_declaration.add(declaration16.getTree());
					}
					break;

				default :
					break loop6;
				}
			}

			// AST REWRITE
			// elements: declaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 80:5: -> ^( LOCALS ( declaration )+ )
			{
				// src/core/koopa/core/grammars/generator/KG.g:80:8: ^( LOCALS ( declaration )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCALS, "LOCALS"), root_1);
				if ( !(stream_declaration.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_declaration.hasNext() ) {
					adaptor.addChild(root_1, stream_declaration.nextTree());
				}
				stream_declaration.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "locals"


	public static class declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// src/core/koopa/core/grammars/generator/KG.g:83:1: declaration : IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
	public final KGParser.declaration_return declaration() throws RecognitionException {
		KGParser.declaration_return retval = new KGParser.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIER17=null;
		Token IDENTIFIER18=null;

		CommonTree IDENTIFIER17_tree=null;
		CommonTree IDENTIFIER18_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:84:3: ( IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KG.g:84:5: IDENTIFIER IDENTIFIER
			{
			IDENTIFIER17=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration519);  
			stream_IDENTIFIER.add(IDENTIFIER17);

			IDENTIFIER18=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration521);  
			stream_IDENTIFIER.add(IDENTIFIER18);

			// AST REWRITE
			// elements: IDENTIFIER, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 86:5: -> ^( DECLARATION IDENTIFIER IDENTIFIER )
			{
				// src/core/koopa/core/grammars/generator/KG.g:86:8: ^( DECLARATION IDENTIFIER IDENTIFIER )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARATION, "DECLARATION"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class sequence_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sequence"
	// src/core/koopa/core/grammars/generator/KG.g:89:1: sequence : (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ ;
	public final KGParser.sequence_return sequence() throws RecognitionException {
		KGParser.sequence_return retval = new KGParser.sequence_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		List<Object> list_p=null;
		RuleReturnScope p = null;
		RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:90:3: ( (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ )
			// src/core/koopa/core/grammars/generator/KG.g:90:5: (p+= part )+
			{
			// src/core/koopa/core/grammars/generator/KG.g:90:6: (p+= part )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ANY||LA7_0==BANG||(LA7_0 >= DOLLAR && LA7_0 <= DOT)||LA7_0==IDENTIFIER||(LA7_0 >= LIMIT && LA7_0 <= LITERAL)||LA7_0==NATIVE_CODE||(LA7_0 >= NOSKIP && LA7_0 <= OPEN_PAREN)||LA7_0==SKIP_TO||LA7_0==TAG||LA7_0==WITH) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:90:6: p+= part
					{
					pushFollow(FOLLOW_part_in_sequence551);
					p=part();
					state._fsp--;

					stream_part.add(p.getTree());
					if (list_p==null) list_p=new ArrayList<Object>();
					list_p.add(p.getTree());
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			// AST REWRITE
			// elements: part, part
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 92:5: -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ )
			if ( list_p.size() > 1 ) {
				// src/core/koopa/core/grammars/generator/KG.g:92:27: ^( SEQUENCE ( part )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQUENCE, "SEQUENCE"), root_1);
				if ( !(stream_part.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_part.hasNext() ) {
					adaptor.addChild(root_1, stream_part.nextTree());
				}
				stream_part.reset();

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 93:5: -> ( part )+
			{
				if ( !(stream_part.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_part.hasNext() ) {
					adaptor.addChild(root_0, stream_part.nextTree());
				}
				stream_part.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sequence"


	public static class part_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "part"
	// src/core/koopa/core/grammars/generator/KG.g:96:1: part : (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER |a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN -> { m == null }? ^( DISPATCHED dispatch ) -> ^( DISPATCHED dispatch ( more_dispatch )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) | WITH p= part SKIP_TO q= part -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) ) );
	public final KGParser.part_return part() throws RecognitionException {
		KGParser.part_return retval = new KGParser.part_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token code=null;
		Token a=null;
		Token e=null;
		Token b=null;
		Token r=null;
		Token TAG19=null;
		Token ANY20=null;
		Token LITERAL21=null;
		Token NUMBER22=null;
		Token DOT23=null;
		Token OPEN_PAREN24=null;
		Token CLOSE_PAREN26=null;
		Token OPEN_BRACKET27=null;
		Token CLOSE_BRACKET29=null;
		Token SKIP_TO30=null;
		Token BANG32=null;
		Token OPEN_PAREN33=null;
		Token CLOSE_PAREN35=null;
		Token DOLLAR36=null;
		Token OPEN_PAREN37=null;
		Token CLOSE_PAREN39=null;
		Token NOT40=null;
		Token NOSKIP42=null;
		Token LIMIT44=null;
		Token BY46=null;
		Token WITH48=null;
		Token SKIP_TO49=null;
		List<Object> list_m=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope q =null;
		ParserRuleReturnScope sequence25 =null;
		ParserRuleReturnScope sequence28 =null;
		ParserRuleReturnScope part31 =null;
		ParserRuleReturnScope sequence34 =null;
		ParserRuleReturnScope dispatch38 =null;
		ParserRuleReturnScope part41 =null;
		ParserRuleReturnScope part43 =null;
		ParserRuleReturnScope part45 =null;
		ParserRuleReturnScope part47 =null;
		RuleReturnScope m = null;
		CommonTree code_tree=null;
		CommonTree a_tree=null;
		CommonTree e_tree=null;
		CommonTree b_tree=null;
		CommonTree r_tree=null;
		CommonTree TAG19_tree=null;
		CommonTree ANY20_tree=null;
		CommonTree LITERAL21_tree=null;
		CommonTree NUMBER22_tree=null;
		CommonTree DOT23_tree=null;
		CommonTree OPEN_PAREN24_tree=null;
		CommonTree CLOSE_PAREN26_tree=null;
		CommonTree OPEN_BRACKET27_tree=null;
		CommonTree CLOSE_BRACKET29_tree=null;
		CommonTree SKIP_TO30_tree=null;
		CommonTree BANG32_tree=null;
		CommonTree OPEN_PAREN33_tree=null;
		CommonTree CLOSE_PAREN35_tree=null;
		CommonTree DOLLAR36_tree=null;
		CommonTree OPEN_PAREN37_tree=null;
		CommonTree CLOSE_PAREN39_tree=null;
		CommonTree NOT40_tree=null;
		CommonTree NOSKIP42_tree=null;
		CommonTree LIMIT44_tree=null;
		CommonTree BY46_tree=null;
		CommonTree WITH48_tree=null;
		CommonTree SKIP_TO49_tree=null;
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_OPEN_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_BRACKET");
		RewriteRuleTokenStream stream_CLOSE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSE_BRACKET");
		RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
		RewriteRuleTokenStream stream_ANY=new RewriteRuleTokenStream(adaptor,"token ANY");
		RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
		RewriteRuleTokenStream stream_SKIP_TO=new RewriteRuleTokenStream(adaptor,"token SKIP_TO");
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
		RewriteRuleTokenStream stream_NATIVE_CODE=new RewriteRuleTokenStream(adaptor,"token NATIVE_CODE");
		RewriteRuleTokenStream stream_DOLLAR=new RewriteRuleTokenStream(adaptor,"token DOLLAR");
		RewriteRuleTokenStream stream_NOSKIP=new RewriteRuleTokenStream(adaptor,"token NOSKIP");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
		RewriteRuleSubtreeStream stream_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule dispatch");
		RewriteRuleSubtreeStream stream_more_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule more_dispatch");
		RewriteRuleSubtreeStream stream_more=new RewriteRuleSubtreeStream(adaptor,"rule more");
		RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:97:3: (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER |a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN -> { m == null }? ^( DISPATCHED dispatch ) -> ^( DISPATCHED dispatch ( more_dispatch )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) | WITH p= part SKIP_TO q= part -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) ) )
			int alt16=16;
			switch ( input.LA(1) ) {
			case NATIVE_CODE:
				{
				alt16=1;
				}
				break;
			case TAG:
				{
				alt16=2;
				}
				break;
			case ANY:
				{
				alt16=3;
				}
				break;
			case LITERAL:
				{
				alt16=4;
				}
				break;
			case NUMBER:
				{
				alt16=5;
				}
				break;
			case IDENTIFIER:
				{
				alt16=6;
				}
				break;
			case DOT:
				{
				alt16=7;
				}
				break;
			case OPEN_PAREN:
				{
				alt16=8;
				}
				break;
			case OPEN_BRACKET:
				{
				alt16=9;
				}
				break;
			case SKIP_TO:
				{
				alt16=10;
				}
				break;
			case BANG:
				{
				alt16=11;
				}
				break;
			case DOLLAR:
				{
				alt16=12;
				}
				break;
			case NOT:
				{
				alt16=13;
				}
				break;
			case NOSKIP:
				{
				alt16=14;
				}
				break;
			case LIMIT:
				{
				alt16=15;
				}
				break;
			case WITH:
				{
				alt16=16;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:97:5: code= NATIVE_CODE
					{
					code=(Token)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_part592);  
					stream_NATIVE_CODE.add(code);

					 // if (!verifyNativeCode(code)) {
					      //	throw new RecognitionException("Not a valid java block.", code.getFilename(), code.getLine(), code.getColumn());
					      // }
					    
					// AST REWRITE
					// elements: NATIVE_CODE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 102:5: -> ^( ACT NATIVE_CODE )
					{
						// src/core/koopa/core/grammars/generator/KG.g:102:8: ^( ACT NATIVE_CODE )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ACT, "ACT"), root_1);
						adaptor.addChild(root_1, stream_NATIVE_CODE.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KG.g:104:5: TAG
					{
					root_0 = (CommonTree)adaptor.nil();


					TAG19=(Token)match(input,TAG,FOLLOW_TAG_in_part617); 
					TAG19_tree = (CommonTree)adaptor.create(TAG19);
					adaptor.addChild(root_0, TAG19_tree);

					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KG.g:106:5: ANY
					{
					root_0 = (CommonTree)adaptor.nil();


					ANY20=(Token)match(input,ANY,FOLLOW_ANY_in_part624); 
					ANY20_tree = (CommonTree)adaptor.create(ANY20);
					adaptor.addChild(root_0, ANY20_tree);

					}
					break;
				case 4 :
					// src/core/koopa/core/grammars/generator/KG.g:108:5: LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					LITERAL21=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_part631); 
					LITERAL21_tree = (CommonTree)adaptor.create(LITERAL21);
					adaptor.addChild(root_0, LITERAL21_tree);

					}
					break;
				case 5 :
					// src/core/koopa/core/grammars/generator/KG.g:110:5: NUMBER
					{
					root_0 = (CommonTree)adaptor.nil();


					NUMBER22=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part638); 
					NUMBER22_tree = (CommonTree)adaptor.create(NUMBER22);
					adaptor.addChild(root_0, NUMBER22_tree);

					}
					break;
				case 6 :
					// src/core/koopa/core/grammars/generator/KG.g:112:5: a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )?
					{
					a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part649);  
					stream_IDENTIFIER.add(a);

					// src/core/koopa/core/grammars/generator/KG.g:113:5: (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==EQUALS) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:113:6: e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY )
							{
							e=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_part659);  
							stream_EQUALS.add(e);

							// src/core/koopa/core/grammars/generator/KG.g:113:15: (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY )
							int alt8=4;
							switch ( input.LA(1) ) {
							case IDENTIFIER:
								{
								alt8=1;
								}
								break;
							case NUMBER:
								{
								alt8=2;
								}
								break;
							case DOT:
								{
								alt8=3;
								}
								break;
							case ANY:
								{
								alt8=4;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 8, 0, input);
								throw nvae;
							}
							switch (alt8) {
								case 1 :
									// src/core/koopa/core/grammars/generator/KG.g:113:16: b= IDENTIFIER
									{
									b=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part664);  
									stream_IDENTIFIER.add(b);

									}
									break;
								case 2 :
									// src/core/koopa/core/grammars/generator/KG.g:113:31: b= NUMBER
									{
									b=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part670);  
									stream_NUMBER.add(b);

									}
									break;
								case 3 :
									// src/core/koopa/core/grammars/generator/KG.g:113:42: b= DOT
									{
									b=(Token)match(input,DOT,FOLLOW_DOT_in_part676);  
									stream_DOT.add(b);

									}
									break;
								case 4 :
									// src/core/koopa/core/grammars/generator/KG.g:113:50: b= ANY
									{
									b=(Token)match(input,ANY,FOLLOW_ANY_in_part682);  
									stream_ANY.add(b);

									}
									break;

							}

							}
							break;

					}

					// AST REWRITE
					// elements: a, b, IDENTIFIER
					// token labels: a, b
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
					RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 115:5: -> { e != null }? ^( ASSIGN $a $b)
					if ( e != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:115:23: ^( ASSIGN $a $b)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						adaptor.addChild(root_1, stream_a.nextNode());
						adaptor.addChild(root_1, stream_b.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 116:5: -> IDENTIFIER
					{
						adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// src/core/koopa/core/grammars/generator/KG.g:118:5: DOT
					{
					root_0 = (CommonTree)adaptor.nil();


					DOT23=(Token)match(input,DOT,FOLLOW_DOT_in_part723); 
					DOT23_tree = (CommonTree)adaptor.create(DOT23);
					adaptor.addChild(root_0, DOT23_tree);

					}
					break;
				case 8 :
					// src/core/koopa/core/grammars/generator/KG.g:120:5: OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )?
					{
					OPEN_PAREN24=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part730);  
					stream_OPEN_PAREN.add(OPEN_PAREN24);

					pushFollow(FOLLOW_sequence_in_part732);
					sequence25=sequence();
					state._fsp--;

					stream_sequence.add(sequence25.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:120:26: (m+= more )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==PIPE) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:120:26: m+= more
							{
							pushFollow(FOLLOW_more_in_part736);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop10;
						}
					}

					CLOSE_PAREN26=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part739);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN26);

					// src/core/koopa/core/grammars/generator/KG.g:120:46: (r= STAR |r= PLUS )?
					int alt11=3;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==STAR) ) {
						alt11=1;
					}
					else if ( (LA11_0==PLUS) ) {
						alt11=2;
					}
					switch (alt11) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:120:47: r= STAR
							{
							r=(Token)match(input,STAR,FOLLOW_STAR_in_part744);  
							stream_STAR.add(r);

							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KG.g:120:56: r= PLUS
							{
							r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part750);  
							stream_PLUS.add(r);

							}
							break;

					}

					// AST REWRITE
					// elements: r, r, sequence, more, more, sequence, sequence, sequence
					// token labels: r
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 122:5: -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) )
					if ( r != null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:122:36: ^( $r ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:122:41: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);
						adaptor.addChild(root_2, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:122:59: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_2, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 123:5: -> { r != null && m == null }? ^( $r sequence )
					if ( r != null && m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:123:36: ^( $r sequence )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 124:5: -> { r == null && m != null }? ^( CHOICE sequence ( more )* )
					if ( r == null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:124:36: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:124:54: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_1, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 125:5: -> sequence
					{
						adaptor.addChild(root_0, stream_sequence.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 9 :
					// src/core/koopa/core/grammars/generator/KG.g:127:5: OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )?
					{
					OPEN_BRACKET27=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part822);  
					stream_OPEN_BRACKET.add(OPEN_BRACKET27);

					pushFollow(FOLLOW_sequence_in_part824);
					sequence28=sequence();
					state._fsp--;

					stream_sequence.add(sequence28.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:127:28: (m+= more )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==PIPE) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:127:28: m+= more
							{
							pushFollow(FOLLOW_more_in_part828);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop12;
						}
					}

					CLOSE_BRACKET29=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part831);  
					stream_CLOSE_BRACKET.add(CLOSE_BRACKET29);

					// src/core/koopa/core/grammars/generator/KG.g:127:50: (r= STAR |r= PLUS )?
					int alt13=3;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==STAR) ) {
						alt13=1;
					}
					else if ( (LA13_0==PLUS) ) {
						alt13=2;
					}
					switch (alt13) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:127:51: r= STAR
							{
							r=(Token)match(input,STAR,FOLLOW_STAR_in_part836);  
							stream_STAR.add(r);

							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KG.g:127:60: r= PLUS
							{
							r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part842);  
							stream_PLUS.add(r);

							}
							break;

					}

					// AST REWRITE
					// elements: more, r, r, sequence, more, sequence, sequence, sequence
					// token labels: r
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 129:5: -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
					if ( r != null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:129:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:129:41: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);
						// src/core/koopa/core/grammars/generator/KG.g:129:52: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);
						adaptor.addChild(root_3, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:129:70: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_3, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 130:5: -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
					if ( r != null && m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:130:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:130:41: ^( OPTIONAL ^( CHOICE sequence ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);
						// src/core/koopa/core/grammars/generator/KG.g:130:52: ^( CHOICE sequence )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);
						adaptor.addChild(root_3, stream_sequence.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 131:5: -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
					if ( r == null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:131:36: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:131:47: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);
						adaptor.addChild(root_2, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:131:65: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_2, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 132:5: -> ^( OPTIONAL sequence )
					{
						// src/core/koopa/core/grammars/generator/KG.g:132:8: ^( OPTIONAL sequence )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 10 :
					// src/core/koopa/core/grammars/generator/KG.g:134:5: SKIP_TO part
					{
					SKIP_TO30=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part934);  
					stream_SKIP_TO.add(SKIP_TO30);

					pushFollow(FOLLOW_part_in_part936);
					part31=part();
					state._fsp--;

					stream_part.add(part31.getTree());
					// AST REWRITE
					// elements: SKIP_TO, part
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 136:5: -> ^( SKIP_TO part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:136:8: ^( SKIP_TO part )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_SKIP_TO.nextNode(), root_1);
						adaptor.addChild(root_1, stream_part.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 11 :
					// src/core/koopa/core/grammars/generator/KG.g:138:5: BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN
					{
					BANG32=(Token)match(input,BANG,FOLLOW_BANG_in_part960);  
					stream_BANG.add(BANG32);

					OPEN_PAREN33=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part962);  
					stream_OPEN_PAREN.add(OPEN_PAREN33);

					pushFollow(FOLLOW_sequence_in_part964);
					sequence34=sequence();
					state._fsp--;

					stream_sequence.add(sequence34.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:138:31: (m+= more )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==PIPE) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:138:31: m+= more
							{
							pushFollow(FOLLOW_more_in_part968);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop14;
						}
					}

					CLOSE_PAREN35=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part971);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN35);

					// AST REWRITE
					// elements: sequence, more, sequence
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 140:5: -> { m == null }? ^( OPTIONAL sequence )
					if ( m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:140:23: ^( OPTIONAL sequence )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 141:5: -> ^( PERMUTED sequence ( more )* )
					{
						// src/core/koopa/core/grammars/generator/KG.g:141:8: ^( PERMUTED sequence ( more )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:141:28: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_1, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 12 :
					// src/core/koopa/core/grammars/generator/KG.g:143:5: DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN
					{
					DOLLAR36=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_part1014);  
					stream_DOLLAR.add(DOLLAR36);

					OPEN_PAREN37=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part1016);  
					stream_OPEN_PAREN.add(OPEN_PAREN37);

					pushFollow(FOLLOW_dispatch_in_part1018);
					dispatch38=dispatch();
					state._fsp--;

					stream_dispatch.add(dispatch38.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:143:33: (m+= more_dispatch )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==PIPE) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:143:33: m+= more_dispatch
							{
							pushFollow(FOLLOW_more_dispatch_in_part1022);
							m=more_dispatch();
							state._fsp--;

							stream_more_dispatch.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop15;
						}
					}

					CLOSE_PAREN39=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part1025);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN39);

					// AST REWRITE
					// elements: more_dispatch, dispatch, dispatch
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 145:5: -> { m == null }? ^( DISPATCHED dispatch )
					if ( m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:145:23: ^( DISPATCHED dispatch )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DISPATCHED, "DISPATCHED"), root_1);
						adaptor.addChild(root_1, stream_dispatch.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 146:5: -> ^( DISPATCHED dispatch ( more_dispatch )* )
					{
						// src/core/koopa/core/grammars/generator/KG.g:146:8: ^( DISPATCHED dispatch ( more_dispatch )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DISPATCHED, "DISPATCHED"), root_1);
						adaptor.addChild(root_1, stream_dispatch.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:146:30: ( more_dispatch )*
						while ( stream_more_dispatch.hasNext() ) {
							adaptor.addChild(root_1, stream_more_dispatch.nextTree());
						}
						stream_more_dispatch.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 13 :
					// src/core/koopa/core/grammars/generator/KG.g:148:5: NOT part
					{
					NOT40=(Token)match(input,NOT,FOLLOW_NOT_in_part1068);  
					stream_NOT.add(NOT40);

					pushFollow(FOLLOW_part_in_part1070);
					part41=part();
					state._fsp--;

					stream_part.add(part41.getTree());
					// AST REWRITE
					// elements: part, NOT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 149:5: -> ^( NOT part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:149:8: ^( NOT part )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_part.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 14 :
					// src/core/koopa/core/grammars/generator/KG.g:151:5: NOSKIP part
					{
					NOSKIP42=(Token)match(input,NOSKIP,FOLLOW_NOSKIP_in_part1089);  
					stream_NOSKIP.add(NOSKIP42);

					pushFollow(FOLLOW_part_in_part1091);
					part43=part();
					state._fsp--;

					stream_part.add(part43.getTree());
					// AST REWRITE
					// elements: part, NOSKIP
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 152:3: -> ^( NOSKIP part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:152:6: ^( NOSKIP part )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_NOSKIP.nextNode(), root_1);
						adaptor.addChild(root_1, stream_part.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 15 :
					// src/core/koopa/core/grammars/generator/KG.g:154:5: LIMIT part BY part
					{
					LIMIT44=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_part1108);  
					stream_LIMIT.add(LIMIT44);

					pushFollow(FOLLOW_part_in_part1110);
					part45=part();
					state._fsp--;

					stream_part.add(part45.getTree());
					BY46=(Token)match(input,BY,FOLLOW_BY_in_part1112);  
					stream_BY.add(BY46);

					pushFollow(FOLLOW_part_in_part1114);
					part47=part();
					state._fsp--;

					stream_part.add(part47.getTree());
					// AST REWRITE
					// elements: part, LIMIT, part
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 155:3: -> ^( LIMIT part part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:155:6: ^( LIMIT part part )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_LIMIT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_part.nextTree());
						adaptor.addChild(root_1, stream_part.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 16 :
					// src/core/koopa/core/grammars/generator/KG.g:157:5: WITH p= part SKIP_TO q= part
					{
					WITH48=(Token)match(input,WITH,FOLLOW_WITH_in_part1133);  
					stream_WITH.add(WITH48);

					pushFollow(FOLLOW_part_in_part1137);
					p=part();
					state._fsp--;

					stream_part.add(p.getTree());
					SKIP_TO49=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part1139);  
					stream_SKIP_TO.add(SKIP_TO49);

					pushFollow(FOLLOW_part_in_part1143);
					q=part();
					state._fsp--;

					stream_part.add(q.getTree());
					// AST REWRITE
					// elements: q, SKIP_TO, p, q
					// token labels: 
					// rule labels: p, q, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.getTree():null);
					RewriteRuleSubtreeStream stream_q=new RewriteRuleSubtreeStream(adaptor,"rule q",q!=null?q.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 158:3: -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) )
					{
						// src/core/koopa/core/grammars/generator/KG.g:158:6: ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQUENCE, "SEQUENCE"), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:159:8: ^( LIMIT $p $q)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIMIT, "LIMIT"), root_2);
						adaptor.addChild(root_2, stream_p.nextTree());
						adaptor.addChild(root_2, stream_q.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// src/core/koopa/core/grammars/generator/KG.g:160:8: ^( SKIP_TO $q)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_SKIP_TO.nextNode(), root_2);
						adaptor.addChild(root_2, stream_q.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "part"


	public static class more_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "more"
	// src/core/koopa/core/grammars/generator/KG.g:163:1: more : PIPE sequence -> sequence ;
	public final KGParser.more_return more() throws RecognitionException {
		KGParser.more_return retval = new KGParser.more_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PIPE50=null;
		ParserRuleReturnScope sequence51 =null;

		CommonTree PIPE50_tree=null;
		RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:164:3: ( PIPE sequence -> sequence )
			// src/core/koopa/core/grammars/generator/KG.g:164:5: PIPE sequence
			{
			PIPE50=(Token)match(input,PIPE,FOLLOW_PIPE_in_more1195);  
			stream_PIPE.add(PIPE50);

			pushFollow(FOLLOW_sequence_in_more1197);
			sequence51=sequence();
			state._fsp--;

			stream_sequence.add(sequence51.getTree());
			// AST REWRITE
			// elements: sequence
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 166:5: -> sequence
			{
				adaptor.addChild(root_0, stream_sequence.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "more"


	public static class dispatch_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dispatch"
	// src/core/koopa/core/grammars/generator/KG.g:169:1: dispatch : IDENTIFIER ARROW sequence -> ^( CASE IDENTIFIER sequence ) ;
	public final KGParser.dispatch_return dispatch() throws RecognitionException {
		KGParser.dispatch_return retval = new KGParser.dispatch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIER52=null;
		Token ARROW53=null;
		ParserRuleReturnScope sequence54 =null;

		CommonTree IDENTIFIER52_tree=null;
		CommonTree ARROW53_tree=null;
		RewriteRuleTokenStream stream_ARROW=new RewriteRuleTokenStream(adaptor,"token ARROW");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:170:3: ( IDENTIFIER ARROW sequence -> ^( CASE IDENTIFIER sequence ) )
			// src/core/koopa/core/grammars/generator/KG.g:170:5: IDENTIFIER ARROW sequence
			{
			IDENTIFIER52=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_dispatch1223);  
			stream_IDENTIFIER.add(IDENTIFIER52);

			ARROW53=(Token)match(input,ARROW,FOLLOW_ARROW_in_dispatch1225);  
			stream_ARROW.add(ARROW53);

			pushFollow(FOLLOW_sequence_in_dispatch1227);
			sequence54=sequence();
			state._fsp--;

			stream_sequence.add(sequence54.getTree());
			// AST REWRITE
			// elements: sequence, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 172:5: -> ^( CASE IDENTIFIER sequence )
			{
				// src/core/koopa/core/grammars/generator/KG.g:172:8: ^( CASE IDENTIFIER sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CASE, "CASE"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dispatch"


	public static class more_dispatch_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "more_dispatch"
	// src/core/koopa/core/grammars/generator/KG.g:175:1: more_dispatch : PIPE dispatch -> dispatch ;
	public final KGParser.more_dispatch_return more_dispatch() throws RecognitionException {
		KGParser.more_dispatch_return retval = new KGParser.more_dispatch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PIPE55=null;
		ParserRuleReturnScope dispatch56 =null;

		CommonTree PIPE55_tree=null;
		RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
		RewriteRuleSubtreeStream stream_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule dispatch");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:176:3: ( PIPE dispatch -> dispatch )
			// src/core/koopa/core/grammars/generator/KG.g:176:5: PIPE dispatch
			{
			PIPE55=(Token)match(input,PIPE,FOLLOW_PIPE_in_more_dispatch1259);  
			stream_PIPE.add(PIPE55);

			pushFollow(FOLLOW_dispatch_in_more_dispatch1261);
			dispatch56=dispatch();
			state._fsp--;

			stream_dispatch.add(dispatch56.getTree());
			// AST REWRITE
			// elements: dispatch
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 178:5: -> dispatch
			{
				adaptor.addChild(root_0, stream_dispatch.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "more_dispatch"

	// Delegated rules



	public static final BitSet FOLLOW_meta_in_koopa146 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_rule_in_koopa155 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_EOF_in_koopa158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_meta192 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_meta196 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_meta200 = new BitSet(new long[]{0x0040000000200000L});
	public static final BitSet FOLLOW_54_in_meta207 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_meta211 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DOT_in_meta219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_rule329 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule333 = new BitSet(new long[]{0x0100004000400000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_rule342 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_locals_in_rule346 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_rule348 = new BitSet(new long[]{0x0100000000400000L});
	public static final BitSet FOLLOW_56_in_rule359 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule363 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQUALS_in_rule367 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_rule378 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_rule387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_locals485 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_locals488 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_declaration_in_locals490 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration519 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_part_in_sequence551 = new BitSet(new long[]{0x0009407D1A300122L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_part592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAG_in_part617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_part624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_part631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_part638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_part649 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_EQUALS_in_part659 = new BitSet(new long[]{0x0000001002200020L});
	public static final BitSet FOLLOW_IDENTIFIER_in_part664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_part670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_part676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_part682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_part723 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part730 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part732 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_in_part736 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part739 = new BitSet(new long[]{0x0000840000000002L});
	public static final BitSet FOLLOW_STAR_in_part744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_part750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_BRACKET_in_part822 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part824 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_more_in_part828 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_CLOSE_BRACKET_in_part831 = new BitSet(new long[]{0x0000840000000002L});
	public static final BitSet FOLLOW_STAR_in_part836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_part842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SKIP_TO_in_part934 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part936 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_part960 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part962 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part964 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_in_part968 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOLLAR_in_part1014 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part1016 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_dispatch_in_part1018 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_dispatch_in_part1022 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_part1068 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1070 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOSKIP_in_part1089 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1091 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_part1108 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1110 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_BY_in_part1112 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WITH_in_part1133 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1137 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SKIP_TO_in_part1139 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_part_in_part1143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PIPE_in_more1195 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_more1197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_dispatch1223 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ARROW_in_dispatch1225 = new BitSet(new long[]{0x0009407D1A300120L});
	public static final BitSet FOLLOW_sequence_in_dispatch1227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PIPE_in_more_dispatch1259 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_dispatch_in_more_dispatch1261 = new BitSet(new long[]{0x0000000000000002L});
}
