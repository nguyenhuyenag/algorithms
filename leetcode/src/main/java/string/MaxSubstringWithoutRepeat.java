package string;

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

//    public static int lengthOfLongestSubstring0(String s) {
//        int max = 0;
//        String[] arr = s.split("");
//        int n = s.length();
//        for (int i = 0; i < n; i++) {               // với mỗi i
//            StringBuilder str = new StringBuilder(arr[i]);
//            for (int j = i + 1; j < n; j++) {       // ta thêm các ký tự phía sau i để tạo ra chuỗi con
//                if (str.indexOf(arr[j]) == -1) {
//                    str.append(arr[j]);             // nếu chưa có thì
//                } else {
//                    break;                          // nếu đã có thì thoát
//                }
//            }
//            max = Math.max(max, str.length());      // chạy hết chuỗi hoặc bị thoát, so sánh str với max
//        }
//        return max;
//    }

//    public int lengthOfLongestSubstring0(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        Map<Character, Integer> charIndexMap = new HashMap<>();
//        int maxLength = 0;
//        int pointer = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (charIndexMap.containsKey(ch)) {
//                pointer = Math.max(charIndexMap.get(ch) + 1, pointer);
//            }
//            maxLength = Math.max(maxLength, i - pointer + 1);
//            charIndexMap.put(ch, i);
//        }
//        return maxLength;
//    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len <= 1) return len;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.add(s.charAt(j))) {
                    max = Math.max(max, set.size());
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            // Nếu có ký tự trùng -> loại bỏ nó khỏi set và tăng j lên
            if (set.contains(currentChar)) {
                set.remove(s.charAt(j++));
            } else {
                // Nếu chưa có thì thêm mới và cập nhật lại max
                set.add(currentChar);
                max = Math.max(max, set.size());
                i++;
            }
        }
        return max;
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
