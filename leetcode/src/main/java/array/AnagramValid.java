package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/valid-anagram/

    Anagrams là 2 chuỗi s1, s2 có cùng những ký tự (bằng nhau sau khi sắp xếp)

    Xem thêm GroupAnagrams.java
 */
public class AnagramValid {

    public boolean isAnagram_1(String s1, String s2) {
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

    public boolean isAnagram_2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] mark = new int[26];
        s1.chars().forEach(c -> mark[c - 'a']++);
        s2.chars().forEach(c -> mark[c - 'a']--);
        return Arrays.stream(mark).allMatch(v -> v == 0);
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> counter = new HashMap<>();

        // Increment character counts for s1
        for (char c : s1.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        // Decrement character counts for s2
        for (char c : s2.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }

        // Check if all character counts are zero
        return counter.values().stream().allMatch(v -> v == 0);
    }

    @Test
    public void test() {
        assertEquals(true, isAnagram("anagram", "nagaram"));
        assertEquals(false, isAnagram("rat", "car"));
    }

}
