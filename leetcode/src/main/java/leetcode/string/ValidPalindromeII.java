package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*-
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

	private boolean isPalindrome(String str, int l, int r) {
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	/*-
	 * Gọi i = left, j = right, nếu s đối xứng thì sub s sau khi bỏ i, j cũng đối xứng
	 * 
	 * s[i] != s[j] => Kiểm tra đối xứng của chuỗi con khi xóa i hoặc xóa j
	 * 
	 * s[i] == s[j] => dời i và j vào trong
	 */
	public boolean validPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1);
			}
			i++;
			j--;
		}
		return true;
	}

	@Test
	public void test() {
		assertEquals(true, validPalindrome("aba"));
		assertEquals(true, validPalindrome("abca"));
		assertEquals(false, validPalindrome("abc"));
	}

}
