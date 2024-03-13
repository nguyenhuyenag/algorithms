package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Anagrams là 2 chuỗi s1, s2 có cùng những ký tự (bằng nhau sau khi sắp xếp)
 *
 * Xem thêm GroupAnagrams.java
 */
public class AnagramValid {

    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] mark = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']--;
        }
        for (char v : mark) {
            if (v != 0) return false;
        }
        return true;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] mark = new int[26];
        s1.chars().forEach(c -> mark[c - 'a']++);
        s2.chars().forEach(c -> mark[c - 'a']--);
        return Arrays.stream(mark).allMatch(v -> v == 0);
    }

    @Test
    public void test() {
        assertEquals(true, isAnagrams("anagram", "nagaram"));
    }

}
