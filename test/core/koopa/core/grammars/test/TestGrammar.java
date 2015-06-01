package koopa.core.grammars.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.grammars.combinators.Opt;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Block;

/**
 * This class exposes all parser combinator methods for testing. It can be
 * configured with a list of Strings to be used as separators.
 */
public class TestGrammar extends KoopaGrammar {

	private final Set<String> separators;

	public TestGrammar(String... separators) {
		this.separators = new HashSet<String>(Arrays.asList(separators));
	}

	// ========================================================================

	@Override
	public String getNamespace() {
		return "test";
	}

	@Override
	public boolean isSeparator(String text) {
		return separators.contains(text);
	}

	@Override
	public boolean isProgramText(Token token) {
		return true;
	}

	@Override
	public FutureParser scoped(String name) {
		return super.scoped(name);
	}

	@Override
	public ParserCombinator apply(Block func) {
		return super.apply(func);
	}

	@Override
	public ParserCombinator assign(String name, ParserCombinator parser) {
		return super.assign(name, parser);
	}

	@Override
	public ParserCombinator choice(ParserCombinator... parsers) {
		return super.choice(parsers);
	}

	@Override
	public ParserCombinator star(ParserCombinator parser) {
		return super.star(parser);
	}

	@Override
	public ParserCombinator plus(ParserCombinator parser) {
		return super.plus(parser);
	}

	@Override
	public ParserCombinator optional(ParserCombinator parser) {
		return super.optional(parser);
	}

	@Override
	public ParserCombinator permuted(ParserCombinator... parsers) {
		return super.permuted(parsers);
	}

	@Override
	public ParserCombinator returning(String name) {
		return super.returning(name);
	}

	@Override
	public ParserCombinator token(String text) {
		return super.token(text);
	}

	@Override
	public ParserCombinator sequence(ParserCombinator... parsers) {
		return super.sequence(parsers);
	}

	@Override
	public ParserCombinator skipto(ParserCombinator parser) {
		return super.skipto(parser);
	}

	@Override
	public ParserCombinator not(ParserCombinator parser) {
		return super.not(parser);
	}

	@Override
	public ParserCombinator any() {
		return super.any();
	}

	@Override
	public ParserCombinator tagged(Object tag) {
		return super.tagged(tag);
	}

	@Override
	public ParserCombinator opt(Opt opt, ParserCombinator parser) {
		return super.opt(opt, parser);
	}

	@Override
	public ParserCombinator limited(ParserCombinator target, ParserCombinator limiter) {
		return super.limited(target, limiter);
	}

	@Override
	public ParserCombinator dispatched(String[] keys, ParserCombinator[] parsers) {
		return super.dispatched(keys, parsers);
	}

	@Override
	public ParserCombinator as(String name, ParserCombinator parser) {
		return super.as(name, parser);
	}

	@Override
	public ParserCombinator eof() {
		return super.eof();
	}

	@Override
	protected ParserCombinator literal(String text) {
		return super.literal(text);
	}
}
