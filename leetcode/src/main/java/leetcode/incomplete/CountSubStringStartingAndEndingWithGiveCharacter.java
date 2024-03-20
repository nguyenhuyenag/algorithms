package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/
 *
 * Cho chuỗi s và ký tự c. Đếm số chuỗi con bắt đầu và kết thúc bởi c
 */
public class CountSubStringStartingAndEndingWithGiveCharacter {

    public long countSubstrings(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                int start = i;
                int end = i;

                // Count substrings ending at this 'c'
                while (end < s.length() && s.charAt(end) == c) {
                    count++;
                    end++;
                }

                // Count substrings starting from this 'c'
                while (start >= 0 && s.charAt(start) == c) {
                    count++;
                    start--;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assertions.assertEquals(6, countSubstrings("abada", 'a'));
    }

}
