package string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Tìm độ dài của ùuwf
 */
public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		s = s.trim();
		int lastIndex = s.lastIndexOf(" ") + 1; // Tìm vị trí của khoảng trắng cuối cùng
		return s.length() - lastIndex;
	}

	@Test
	public void test() {
		assertEquals(0, lengthOfLastWord(""));
		assertEquals(0, lengthOfLastWord(" "));
		assertEquals(1, lengthOfLastWord("a"));
		assertEquals(5, lengthOfLastWord("Hello World"));
	}

}
