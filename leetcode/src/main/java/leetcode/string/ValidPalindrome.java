package leetcode.string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * Given a string s, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	public boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			while (i <= j && !Character.isLetterOrDigit(str.charAt(i))) {
				i++;
			}
			while (i <= j && !Character.isLetterOrDigit(str.charAt(j))) {
				j--;
			}
			if (i <= j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	@Test
	public void test() {
		assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
	}
}
