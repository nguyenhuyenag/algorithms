package array;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 *
 * Hai chuỗi s1, s2 được goi là anagrams nếu sort(s1) = sort(s2).
 *
 * Cho mảng words chứa các chuỗi. Nếu words[i] và words[i+1] là anagrams thì xóa word[i+1].
 *
 * Trả về mảng sau khi xóa.
 */
public class FindResultantArrayAfterRemovingAnagrams {

    /**
     * Kiểm tra s1, s2 có phải là anagrams
     */
    public boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] mark = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']--;
        }
        for (int count : mark) if (count != 0) return false;
        return true;
    }

    public boolean isAnagram_2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] mark = new int[26];
        s1.chars().forEach(c -> mark[c - 'a']++);
        s2.chars().forEach(c -> mark[c - 'a']--);
        return Arrays.stream(mark).allMatch(v -> v == 0);
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> result = Arrays.stream(words).collect(Collectors.toList());
        int i = 0;
        while (i < result.size() - 1) {
            String s1 = result.get(i);
            String s2 = result.get(i + 1);
            if (isAnagrams(s1, s2)) {
                result.remove(i + 1);
            } else {
                i++;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        assertIterableEquals(List.of("abba", "cd"), removeAnagrams(new String[]{"abba", "bbaa", "baba", "cd", "cd"}));
        assertIterableEquals(List.of("a", "b", "c", "d", "e"), removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
        assertIterableEquals(List.of("a", "b", "a"), removeAnagrams(new String[]{"a", "b", "a"}));
    }

    // // ---------------------------------------
    //    public int findHashCode(String s) {
//        int[] mark = new int[26];
//        s.chars().forEach(c -> mark[c - 'a']++);
//        return Arrays.hashCode(mark);
//    }
//
//    public List<String> removeAnagrams(String[] words) {
//        List<String> result = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
//        for (String word : words) {
//            int hashCode = findHashCode(word);
//            if (visited.add(hashCode)) {
//                result.add(word);
//            }
//        }
//        return result;
//    }

    // // ---------------------------------------

//    public List<String> removeAnagrams_2(String[] A) {
//        List<String> result = Arrays.stream(A).collect(Collectors.toList());
//        Iterator<String> iterator = result.iterator();
//        if (!iterator.hasNext()) {
//            return result; // Empty list, nothing to remove
//        }
//        String s1 = iterator.next();
//        while (iterator.hasNext()) {
//            String s2 = iterator.next();
//            if (isAnagrams(s1, s2)) {
//                iterator.remove();
//            } else {
//                s1 = s2;
//            }
//        }
//        return result;
//    }
//
//        public static boolean isAnagram(String s, String t) {
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
//
//        public boolean isAnagrams(String s1, String s2) {
//        if (s1.length() != s2.length()) return false;
//        char[] mark = new char[26];
//        for (int i = 0; i < s1.length(); i++) {
//            mark[s1.charAt(i) - 'a']++;
//            mark[s2.charAt(i) - 'a']--;
//        }
//        for (char v : mark) {
//            if (v != 0) return false;
//        }
//        return true;
//    }

}
