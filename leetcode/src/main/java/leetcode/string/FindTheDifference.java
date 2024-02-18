package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-the-difference/
 *
 * Cho chuôi s, và chuỗi t được tạo ngẫu nhiên từ chuỗi s cộng thêm 1 ký tự.
 * Tìm ký tự đó
 */
public class FindTheDifference {

    public char findTheDifference_OK(String s, String t) {
        int[] mark = new int[26];

        // Mark characters in t
        t.chars().forEach(c -> mark[c - 'a']++);

        // Decrease count for characters in s
        s.chars().forEach(c -> mark[c - 'a']--);

        // Find the extra character
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }

    /**
     * Số thêm vào = Tổng_(T) - Tổng_(S)
     */
    public char findTheDifference(String s, String t) {
        int charCodeS = 0, charCodeT = 0;
        for (int i = 0; i < s.length(); i++) {
            charCodeS += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            charCodeT += t.charAt(i);
        }
        return (char) (charCodeT - charCodeS);
    }

    @Test
    public void test() {
        assertEquals('e', findTheDifference("abcd", "abcde"));
        assertEquals('y', findTheDifference("", "y"));
        assertEquals('a', findTheDifference("a", "aa"));
    }

}
