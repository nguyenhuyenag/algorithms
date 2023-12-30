package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class LeetMain {

    public boolean makeEqual(String[] words) {
        String join = String.join("", words);
        char[] arr = join.toCharArray();
        // Arrays.sort(arr);
        // String s = new String(arr);
        return true;
    }

    public boolean makeEqual0(String[] words) {
        int len = words.length;
        int[] charCount = new int[26];
        String join = String.join("", words);

        // Đếm số lần xuất hiện của char
        for (char c : join.toCharArray()) {
            charCount[c - 'a']++;
        }

        // System.out.println("charCount = " + Arrays.toString(charCount));
        for (int count : charCount) {
            /**
             * Kiểm tra thử chia lại số lần xuất hiện của ký tự vào mảng, nếu chia đủ thì true
             *
             *  a4 -> [a, a, a, a] -> true
             *  a3 -> [a, a, a,  ] -> false
             *
             * Giống như chia bài
             */
            if (count % len != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void doTest() {
        assertEquals(true, makeEqual(new String[]{"", ""}));
        assertEquals(false, makeEqual(new String[]{"a", "b"}));
        assertEquals(false, makeEqual(new String[]{"ab", "a"}));
        assertEquals(true, makeEqual(new String[]{"abc", "aabc", "bc"}));
    }

}
