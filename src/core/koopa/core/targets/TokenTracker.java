package koopa.core.targets;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Token;

public class TokenTracker implements Target<Data> {

	private final List<Token> tokens = new ArrayList<Token>();

	@Override
	public void push(Data data) {
		if (data instanceof Token)
			tokens.add((Token) data);
	}

	public List<Token> getTokens() {
		return tokens;
	}

	// TODO This logic breaks when applying preprocessing !
	public Token getTokenAt(int position) {
		final int size = tokens.size();

		if (size == 0) {
			return null;
		}

		int left = 0;
		int right = size - 1;

		while (true) {
			if (left >= right)
				break;

			int mid = (left + right) >> 1;

			Token t = tokens.get(mid);
			if (position < t.getStart().getPositionInFile()) {
				right = mid - 1;
				continue;
			}

			if (position > t.getEnd().getPositionInFile()) {
				left = mid + 1;
				continue;
			}

			return t;
		}

		if (left > right)
			return null;

		Token t = tokens.get(left);

		if (position >= t.getStart().getPositionInFile()
				&& position <= t.getEnd().getPositionInFile())
			return t;

		return null;
	}

	public int getTokenCount() {
		return tokens.size();
	}
}
