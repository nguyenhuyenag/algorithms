package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {

	public static int lengthOfLastWord(String str) {
		str = str.trim();
		int last = str.lastIndexOf(" ") + 1;
		return str.length() - last;
	}

	@Test
	public void test() {
		assertEquals(0, lengthOfLastWord(""));
		assertEquals(0, lengthOfLastWord(" "));
		assertEquals(1, lengthOfLastWord("a"));
		assertEquals(5, lengthOfLastWord("Hello World"));
	}

}
