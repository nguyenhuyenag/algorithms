package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Đảo nguyên âm trong chuỗi
 */
public class ReverseVowelsOfAString {

    public boolean isVowels(char c) {
        return "aeouiAEOUI".indexOf(c) != -1;
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            // Nếu cả 2 là nguyên âm thì đổi chỗ
            if (isVowels(arr[l]) && isVowels(arr[r])) {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            } else if (isVowels(arr[l])) { // left là nguyên âm, right không phải
                r--;
            } else { // right là nguyên âm, left không phải
                l++;
            }
        }
        return new String(arr);
    }

    @Test
    public void test() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("test"));
        assertEquals("Aa", reverseVowels("aA"));
    }

}
