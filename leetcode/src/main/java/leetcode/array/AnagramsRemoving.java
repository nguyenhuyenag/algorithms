package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
public class AnagramsRemoving {

    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] mark = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']--;
        }
        for (char v : mark) {
            if (v != 0) return false;
        }
        return true;
    }

    public boolean hasAnagrams(List<String> list, int index) {
        String s2 = list.get(index);
        String s1 = list.get(index - 1);
        return isAnagrams(s1, s2);
    }

    public List<String> removeAnagrams(String[] A) {
        List<String> result = Arrays.stream(A).collect(Collectors.toList());
        int i = 1;
        while (i < result.size()) {
            if (hasAnagrams(result, i)) {
                result.remove(i);
            } else {
                i++;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        String[] A1 = {"abba", "baba", "bbaa", "cd", "cd"};
        assertIterableEquals(List.of("abba", "cd"), removeAnagrams(A1));
    }

    @Test
    public void test2() {
        String[] A2 = {"a", "b", "c", "d", "e"};
        assertIterableEquals(List.of("a", "b", "c", "d", "e"), removeAnagrams(A2));
    }

    public List<String> removeAnagrams_2(String[] A) {
        List<String> result = Arrays.stream(A).collect(Collectors.toList());
        Iterator<String> iterator = result.iterator();
        if (!iterator.hasNext()) {
            return result; // Empty list, nothing to remove
        }
        String s1 = iterator.next();
        while (iterator.hasNext()) {
            String s2 = iterator.next();
            if (isAnagrams(s1, s2)) {
                iterator.remove();
            } else {
                s1 = s2;
            }
        }
        return result;
    }

    //    public static boolean isAnagram(String s, String t) {
//        int n = s.length();
//        if (s.length() != t.length())
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
//
//    public static List<String> removeAnagrams_0(String[] A) {
//        int n = A.length;
//        int[] mark = new int[n];
//        Arrays.fill(mark, 0);
//        for (int i = 1; i < n; i++) {
//            if (isAnagram(A[i], A[i - 1])) {
//                mark[i] = 1;
//            }
//        }
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (mark[i] == 0) {
//                result.add(A[i]);
//            }
//        }
//        return result;
//    }

}
