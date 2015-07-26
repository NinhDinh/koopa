package koopa.core.util.test;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.Source;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.trees.Tree;

public final class Util {
	public static List<Range> asListOfRanges(int... positions) {
		List<Range> ranges = new ArrayList<Range>();

		for (int i = 0; i < positions.length; i += 2) {
			int from = positions[i];
			int to = positions[i + 1];
			ranges.add(new Range(new Position(from, 0, from), new Position(to,
					0, to)));
		}

		return ranges;
	}

	public static Tree tree(String name, Object... parts) {
		Start start = Start.on("test", name);

		Tree tree = new Tree(start);

		for (Object part : parts) {
			if (part instanceof Tree)
				tree.addChild((Tree) part);
			else if (part instanceof String)
				tree.addChild(token((String) part));
			else
				throw new IllegalArgumentException(
						"This is neither a Tree or a String: " + part);
		}

		return tree;
	}

	public static Tree token(String text, Object... tags) {
		Position start = new Position(0, 0, 0);
		Token token = new Token(text, start, start.offsetBy(text.length()));

		if (tags != null)
			token = token.withTags(tags);

		Tree tree = new Tree(token);

		return tree;
	}

	public static Tree text(String text) {
		return token(text, PROGRAM_TEXT_AREA);
	}

	public static Tree text(String text, int start, int end) {
		return new Tree(new Token(text, new Position(start, 0, start),
				new Position(end, 0, end), PROGRAM_TEXT_AREA));
	}

	public static Tree comment(String text) {
		return token(text, AreaTag.COMMENT);
	}

	public static List<Token> asTokens(Object... tagsAndTokens) {
		final HardcodedSource source = HardcodedSource.from(tagsAndTokens);
		final List<Token> tokens = getAllTokens(source);
		return tokens;
	}

	public static List<Token> getAllTokens(Source<Token> source) {
		final List<Token> tokens = new LinkedList<Token>();

		Token token = null;
		while ((token = source.next()) != null)
			tokens.add(token);

		return tokens;
	}
}
