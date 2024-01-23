package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Cho chuỗi s, tìm chuỗi con dài nhất không chứa các ký tự trùng lặp
 */
public class MaxSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring0(String s) {
        int max = 0;
        String[] arr = s.split("");
        int n = s.length();
        for (int i = 0; i < n; i++) {                // với mỗi i
            StringBuilder str = new StringBuilder(arr[i]);
            for (int j = i + 1; j < n; j++) {         // ta thêm các ký tự phía sau i để tạo ra chuỗi con
                if (str.indexOf(arr[j]) == -1) {
                    str.append(arr[j]);             // nếu chưa có thì
                } else {
                    break;                            // nếu đã có thì thoát
                }
            }
            max = Math.max(max, str.length());        // chạy hết chuỗi hoặc bị thoát, so sánh str với max
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charIndexMap.containsKey(currentChar)) {
                pointer = Math.max(charIndexMap.get(currentChar) + 1, pointer);
            }
            maxLength = Math.max(maxLength, i - pointer + 1);
            charIndexMap.put(currentChar, i);
        }

        return maxLength;
    }

    @Test
    public void test() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, lengthOfLongestSubstring(" "));
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(2, lengthOfLongestSubstring("au"));
    }

}
