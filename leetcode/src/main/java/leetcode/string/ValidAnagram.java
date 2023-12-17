package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Nếu hai chuỗi có các phần tử bằng nhau thì bằng nhau (không tính thứ tự)
 */
public class ValidAnagram {

    public boolean isAnagram(String s1, String s2) {
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

    public boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Queue<Character> que1 = new PriorityQueue<>();
        Queue<Character> que2 = new PriorityQueue<>();
        for (int i = 0; i < s1.length(); i++) {
            que1.add(s1.charAt(i));
            que2.add(s2.charAt(i));
        }
        while (que1.size() > 0) {
            if (!que1.poll().equals(que2.poll())) {
                return false;
            }
        }
        return true;
    }

    @org.junit.jupiter.api.Test
    public void doTest() {
        assertEquals(false, isAnagram("cat", "rat"));
        assertEquals(true, isAnagram("anagram", "nagaram"));
    }

}
