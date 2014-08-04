package koopa.core.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is the main data item generated by Koopa. They represent pieces of text,
 * and can carry some metadata in the form of tags.
 * <p>
 * Tags themselves can be anything; though we recommend using enums.
 * <p>
 * <b>Trying to keep this class immutable.</b>
 */
public class Token implements Data {

	private final String text;
	private final Position start;
	private final Position end;
	private final Set<Object> tags;

	public Token(String text, Position start, Position end, Object... tags) {
		this(text, start, end, new HashSet<Object>(Arrays.asList(tags)));
	}

	public Token(String text, Position start, Position end, Set<Object> tags) {
		this.text = text;
		this.start = start;
		this.end = end;
		this.tags = Collections.unmodifiableSet(tags);
	}

	public Token(List<Token> tokens, Object... tags) {
		this(tokens, new HashSet<Object>(Arrays.asList(tags)));
	}

	public Token(List<Token> tokens, Set<Object> tags) {
		StringBuffer buffer = new StringBuffer();

		for (Token token : tokens)
			buffer.append(token.getText());

		this.text = buffer.toString();

		this.start = tokens.get(0).getStart();
		this.end = tokens.get(tokens.size() - 1).getEnd();
		this.tags = Collections.unmodifiableSet(tags);
	}

	public String getText() {
		return this.text;
	}

	public int getLength() {
		return text.length();
	}

	public Position getStart() {
		return start;
	}

	public Position getEnd() {
		return end;
	}

	public Set<Object> getTags() {
		return tags;
	}

	public boolean hasTag(Object tag) {
		return tags.contains(tag);
	}

	public int tagCount() {
		return tags.size();
	}

	/**
	 * Creates a new token which is a copy of this one, with the addition of the
	 * given tags. If there are no tags given, returns <code>this</code>
	 * instead.
	 */
	public Token withTags(Object... additionalTags) {
		if (additionalTags.length == 0)
			return this;

		Set<Object> newTags = new HashSet<Object>(tags);
		newTags.addAll(Arrays.asList(additionalTags));
		return new Token(text, start, end, newTags);
	}

	/**
	 * Creates a new token which is a copy of this one, with the exception of
	 * the given tags. If there are no tags given, returns <code>this</code>
	 * instead.
	 */
	public Token withoutTags(Object... theseTags) {
		if (theseTags.length == 0)
			return this;

		Set<Object> newTags = new HashSet<Object>(tags);
		newTags.removeAll(Arrays.asList(theseTags));
		return new Token(text, start, end, newTags);
	}

	/**
	 * Creates a new token which is a copy of this one, minus one tag (if
	 * present), and with the addition of the other.
	 */
	public Token replacingTag(Object oldTag, Object newTag) {
		Set<Object> newTags = new HashSet<Object>(tags);
		newTags.remove(oldTag);
		newTags.add(newTag);
		return new Token(text, start, end, newTags);
	}

	@Override
	public String toString() {
		String s = "[" + start + "|" + text + "|" + end + "]";

		if (!tags.isEmpty()) {
			for (Object tag : tags)
				s += " @" + tag;
		}

		return s;
	}
}
