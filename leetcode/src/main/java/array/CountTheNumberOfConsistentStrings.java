package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/count-the-number-of-consistent-strings/

    Cho chuỗi s1 và s2. Đếm số phần tử trong s2 chỉ chứa các  tự trong chuỗi s1.

    s1 = "ab", s2 = ["ad","bd","aaab","baa","badab"]

    => result = ["aaab","baa"] => ket qua = 2
 */
public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;

        boolean[] mark = new boolean[26];
        for (char c : allowed.toCharArray()) {
            mark[c - 'a'] = true;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!mark[c - 'a']) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

}
