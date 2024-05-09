package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

/**
 * Chủ đề: Mảng đánh dấu
 *
 * https://leetcode.com/problems/valid-anagram/
 *
 * Nếu hai chuỗi có các phần tử bằng nhau thì bằng nhau (không tính thứ tự)
 */
public class ValidAnagram {

    public boolean isAnagram0(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        // Lúc này s1.length() = s2.length()
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            charCount.compute(c1, (key, value) -> value == null ? 1 : ++value);
            charCount.compute(c2, (key, value) -> value == null ? -1 : --value);
        }
        for (int v : charCount.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] mark = new int[26];
        s1.chars().forEach(ch -> mark[ch - 'a']++);
        s2.chars().forEach(ch -> mark[ch - 'a']--);
        return Arrays.stream(mark).allMatch(v -> v == 0);
    }

    @Test
    public void doTest() {
        assertEquals(false, isAnagram("cat", "rat"));
        assertEquals(true, isAnagram("anagram", "nagaram"));
    }

    //    public boolean isAnagram1(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        Queue<Character> que1 = new PriorityQueue<>();
//        Queue<Character> que2 = new PriorityQueue<>();
//        for (int i = 0; i < s1.length(); i++) {
//            que1.add(s1.charAt(i));
//            que2.add(s2.charAt(i));
//        }
//        while (que1.size() > 0) {
//            if (!que1.poll().equals(que2.poll())) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean isAnagram(String s1, String s2) {
//        int len = s1.length();
//        if (len != s2.length()) return false;
//        int[] mark = new int[26];
//        for (int i = 0; i < len; i++) {
//            mark[s1.charAt(i) - 'a']++;
//            mark[s2.charAt(i) - 'a']--;
//        }
//        // System.out.println("mark = " + Arrays.toString(mark));
//        for (int v : mark) {
//            if (v != 0) return false;
//        }
//        return true;
//    }

    public boolean isAnagram1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            // Ký tự không xuất hiện trong chuỗi s1 hoặc đã trừ hết lần xuất hiện
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }

}
