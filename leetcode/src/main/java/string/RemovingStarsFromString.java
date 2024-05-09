package string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */
public class RemovingStarsFromString {

	public String removeStars(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c != '*') {
				sb.append(c);
			} else {
				sb.setLength(sb.length() - 1);
			}
		}
		return sb.toString();
	}

	@Test
	public void test() {
		assertEquals("", removeStars("erase*****"));
		assertEquals("lecoe", removeStars("leet**cod*e"));
	}

}
