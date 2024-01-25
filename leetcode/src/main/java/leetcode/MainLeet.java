package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.contains(text2)) return text2.length();
        if (text2.contains(text1)) return text1.length();
        StringBuilder s1 = new StringBuilder(text1);
        StringBuilder s2 = new StringBuilder(text2);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String c = String.valueOf(ch);
            int idx1 = s1.indexOf(c);
            int idx2 = s2.indexOf(c);
            if (idx1 >= 0 && idx2 == -1) {
                // Có trong 1, không có trong 2
                s1 = new StringBuilder(s1.toString().replaceAll(c, ""));
            } else if (idx1 == -1 && idx2 >= 0) {
                // Có trong 2, không có trong 1
                s2 = new StringBuilder(s2.toString().replaceAll(c, ""));
            }
        }
        // System.out.println("s1 = " + s1.toString());
        // System.out.println("s2 = " + s2.toString());
        if (s1.toString().equals(s2.toString())) {
            return s1.length();
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String m1 = s1.toString();
            String m2 = s2.toString();
            String c = String.valueOf(ch);
            int idx1 = m1.indexOf(c);
            int idx2 = m2.indexOf(c);
            if (idx1 >= 0 && idx2 >= 0) {
                m1 = m1.replaceAll(c, "");
                m2 = m2.replaceAll(c, "");
                if (m1.equals(m2)) {
                    return m1.length();
                }
            }
        }
        StringBuilder test = new StringBuilder();
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    test.append(s1.charAt(i));
                }
            }
            System.out.println("test = " + test);
            return test.length();
        } else {
            int j = 0;
            for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    test.append(s1.charAt(i));
                    j++;
                } else {
                    while (j < Math.max(s1.length(), s2.length())) {
                        if (s1.charAt(i) == s2.charAt(j)) {
                            test.append(s1.charAt(i));
                        }
                        j++;
                    }
                }
            }
        }
        return test.length();
    }

    @Test
    public void test() {
//        assertEquals(3, longestCommonSubsequence("abcde", "ace"));
//        assertEquals(3, longestCommonSubsequence("abc", "abc"));
//        assertEquals(0, longestCommonSubsequence("abc", "def"));
//        assertEquals(2, longestCommonSubsequence("ezupkr", "ubmrapg"));
//        assertEquals(1, longestCommonSubsequence("bl", "yby"));
//        assertEquals(2, longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        assertEquals(5, longestCommonSubsequence("abcba", "abcbcba"));
    }

}
