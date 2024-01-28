package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Anagrams là 2 chuỗi s1, s2 có cùng những ký tự (bằng nhau sau khi sắp xếp)
 *
 * Xem thêm GroupAnagrams.java
 */
public class AnagramValid {

    public boolean isAnagrams(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        char[] mark = new char[26];
        for (int i = 0; i < n; i++) {
            mark[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']--;
        }
        for (char v : mark) {
            if (v != 0) return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, isAnagrams("anagram", "nagaram"));
    }

    //    public static boolean isAnagram(String s, String t) {
//        int n = s.length();
//        if (n != t.length())
//            return false;
//        char[] arrs = s.toCharArray();
//        char[] arrt = t.toCharArray();
//        Arrays.sort(arrs);
//        Arrays.sort(arrt);
//        for (int i = 0; i < n; i++) {
//            if (arrs[i] != arrt[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

}
