package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Viết hàm indexOf()
 */
public class FindTheIndexOf {

    public int strStr(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i <= len1 - len2; i++) {
            String sub = s1.substring(i, i + len2);
            if (s2.equals(sub)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr0(String s1, String s2) {
        int i = 0;
        int maxLength = s1.length() - s2.length() + 1;
        while (i < maxLength) {
            String currentSubstring = s1.substring(i, i + s2.length());
            if (s2.equals(currentSubstring)) {
                return i; // Found the substring at this index
            }
            i++;
        }
        return -1; // Substring not found
    }

    public int strStr1(String s1, String s2) {
        return s1.indexOf(s2);
    }

    @Test
    public void doTest() {
        assertEquals(0, strStr("a", "a"));
        assertEquals(2, strStr("hello", "ll"));
        assertEquals(0, strStr("sadbutsad", "sad"));
        assertEquals(-1, strStr("test", "leeto"));
    }

}
