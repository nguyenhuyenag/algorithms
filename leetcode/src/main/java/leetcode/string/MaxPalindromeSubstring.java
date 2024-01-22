package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s
 *
 * Tìm chuỗi con đối xứng dài nhất
 */
public class MaxPalindromeSubstring {

//    public boolean isPalindromic(String str) {
//        int l = 0;
//        int r = str.length() - 1;
//        while (l < r) {
//            if (str.charAt(l) != str.charAt(r)) {
//                return false;
//            }
//            l++;
//            r--;
//        }
//        return true;
//    }
//
//    public String longestPalindrome(String str) {
//        if (isPalindromic(str)) {
//            return str;
//        }
//        String max = "";
//        int n = str.length();
//        for (int i = 0; i < n; i++) { // với mỗi i -> n
//            StringBuilder sb = new StringBuilder();
//            for (int j = i; j < n; j++) {
//                sb.append(str.charAt(j)); // ta cộng vào các chuỗi ở phía sau nó
//                String s = sb.toString();
//                if (isPalindromic(s)) { // nếu chuỗi con này đối xứng
//                    max = (s.length() > max.length() ? s : max); // và > max thì gán nó là max
//                }
//            }
//        }
//        return max;
//    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String maxStr = s.substring(0, 1); // Chuỗi 1 ký tự luôn là chuỗi đối xứng
        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);         // 'bcb'
            String even = expandFromCenter(s, i, i + 1);    // 'bb'
            if (maxStr.length() < Math.max(odd.length(), even.length())) {
                maxStr = (odd.length() > even.length()) ? odd : even;
            }
        }

        return maxStr;
    }

    // Manacher algỏithm: Khai triển ra hai hướng từ tâm
    public String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
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
