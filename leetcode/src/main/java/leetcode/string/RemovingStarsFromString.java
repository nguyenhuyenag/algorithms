package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/removing-stars-from-a-string/
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
	public void test1() {
		String s = "leet**cod*e";
		assertEquals("lecoe", removeStars(s));
	}

	@Test
	public void test2() {
		String s = "erase*****";
		assertEquals("", removeStars(s));
	}

}
