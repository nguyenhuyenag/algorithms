package leetcode.string;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/valid-anagram/
 * <p>
 * Nếu hai chuỗi có các phần tử bằng nhau thì bằng nhau (không tính thứ tự)
 */
public class ValidAnagram {

    public boolean isAnagram(String s1, String s2) {
        // Check if the lengths of both strings are equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        // Sort char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare sorted char arrays
        return Arrays.equals(charArray1, charArray2);
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
