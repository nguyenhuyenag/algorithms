package leetcode.string;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/valid-anagram/
 * <p>
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
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false; // Ký tự không xuất hiện trong chuỗi s1 hoặc đã hết lượt sử dụng
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
        Assertions.assertEquals(false, isAnagram("cat", "rat"));
        Assertions.assertEquals(true, isAnagram("anagram", "nagaram"));
    }

}
