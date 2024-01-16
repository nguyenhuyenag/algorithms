package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * Given a string s, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

//	public boolean isPalindrome(String str) {
//		int i = 0;
//		int j = str.length() - 1;
//		while (i <= j) {
//			while (i <= j && !Character.isLetterOrDigit(str.charAt(i))) {
//				i++;
//			}
//			while (i <= j && !Character.isLetterOrDigit(str.charAt(j))) {
//				j--;
//			}
//			if (i <= j && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
//				return false;
//			}
//			i++;
//			j--;
//		}
//		return true;
//	}

//    public boolean isPalindrome(String input) {
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (Character.isLetterOrDigit(c)) {
//                str.append(Character.toLowerCase(c));
//            }
//        }
//        int l = 0, r = str.length() - 1;
//        while (l < r && str.charAt(l) != str.charAt(r)) {
//            l++;
//            r--;
//        }
//        return l >= r;
//    }

    public boolean isPalindrome(String input) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        // assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(false, isPalindrome("0P"));
    }
}
