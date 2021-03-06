package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class MaxPalindromeSubstring {

	public static boolean isPalindromic(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static String longestPalindrome(String str) {
		if (isPalindromic(str)) {
			return str;
		}
		String max = "";
		int n = str.length();
		for (int i = 0; i < n; i++) { // với mỗi i -> n
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < n; j++) {
				sb.append(str.charAt(j)); // ta cộng vào các chuỗi ở phía sau nó
				String s = sb.toString();
				if (isPalindromic(s)) { // nếu chuỗi con này đối xứng
					max = (s.length() > max.length() ? s : max); // và > max thì gán nó là max
				}
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals("bb", longestPalindrome("cbbd"));
		assertEquals("a", longestPalindrome("a"));
		assertEquals("cc", longestPalindrome("ccd"));
		assertEquals("bb", longestPalindrome("cbbd"));
		assertEquals("bb", longestPalindrome("bb"));
		assertEquals("bb", longestPalindrome("abb"));
		assertEquals("aca", longestPalindrome("aacabdkacaa"));
	}

}
