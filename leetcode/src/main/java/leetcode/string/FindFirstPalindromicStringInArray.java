package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 *
 * Tìm chuỗi đối xứng đầu tiên trong mảng
 */
public class FindFirstPalindromicStringInArray {

    public boolean isPalindromic(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindromic(s)) {
                return s;
            }
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("", firstPalindrome(new String[]{"def", "ghi"}));
        assertEquals("racecar", firstPalindrome(new String[]{"notapalindrome", "racecar"}));
        assertEquals("ada", firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
    }

}
