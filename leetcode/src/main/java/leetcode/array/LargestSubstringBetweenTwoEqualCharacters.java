package leetcode.array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Chủ đề: Mảng đánh đấu
 *
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 *
 * Tìm chuỗi dài nhất ở giữa 2 ký tự giống nhau (khoảng cách giữa lần đầu tiên và lần cuối cùng lớn nhất)
 *
 *      aa          ->      ""          ->      0
 *      abca        ->      bc          ->      2
 *      abcawertya  ->      bcawerty    ->      8
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int len = s.length();
        boolean[] mark = new boolean[26];
        for (int i = 0; i < len - 1; i++) {
            char c = s.charAt(i);
            if (!mark[c - 'a']) { // = false -> Chưa duyệt
                for (int j = i + 1; j < len; j++) {
                    if (c == s.charAt(j)) {
                        int length = j - (i + 1); // s.substring(i + 1, j);
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
            mark[c - 'a'] = true; // Đánh dấu đã duyệt
        }
        return maxLength;
    }

    @Test
    public void doTest() {
        assertEquals(0, maxLengthBetweenEqualCharacters("aa"));
        assertEquals(2, maxLengthBetweenEqualCharacters("abca"));
        assertEquals(-1, maxLengthBetweenEqualCharacters("cbzxy"));
        assertEquals(8, maxLengthBetweenEqualCharacters("abcawertya"));
        assertEquals(18, maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }

}
