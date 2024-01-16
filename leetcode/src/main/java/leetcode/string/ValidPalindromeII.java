package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * <p>
 * Cho một chuỗi s, có thể xóa tối đa 1 ký tự. Liệu chuỗi s có là
 * chuỗi dối xứng sao khi xóa (hoặc không) hay không?
 * <p>
 * https://assets.leetcode.com/users/images/620dc518-3c9f-4d32-8cac-71eb6ee91216_1648864228.2340546.gif
 */
public class ValidPalindromeII {

    public boolean isPalindrome(String str, int l, int r) {
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
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                // Tăng left hoặc giảm right
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
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
