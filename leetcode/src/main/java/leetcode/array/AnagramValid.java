package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Anagrams là 2 chuỗi s1, s2 có cùng những ký tự (bằng nhau sau khi sắp xếp)
 *
 * Xem thêm GroupAnagrams.java
 */
public class AnagramValid {

    public static boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length())
            return false;
        char[] arrs = s.toCharArray();
        char[] arrt = t.toCharArray();
        Arrays.sort(arrs);
        Arrays.sort(arrt);
        for (int i = 0; i < n; i++) {
            if (arrs[i] != arrt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

}
