package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
    Chủ đề: Mảng đánh dấu

    https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

    Hai chuỗi gọi là anagram nếu chúng có tất cả các phần tử bằng nhau (không tính thứ tự).

    Cho 2 chuỗi s, t. Thay thế lần lượt các ký tự trong t sao cho nó thành một anagram của s.

    Trả về số bước nhỏ nhất cần thực hiện.
 */
public class MinimumNumberOfStepsToMake2StringsAnagram {

    public int minSteps(String s, String t) {
        int[] mark = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mark[s.charAt(i) - 'a']++;
            mark[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(mark).filter(v -> v > 0).sum();
    }

    @Test
    public void test() {
        assertEquals(1, minSteps("bab", "aba"));
        assertEquals(5, minSteps("test", "practice"));
        assertEquals(0, minSteps("anagram", "mangaar"));
    }

}
