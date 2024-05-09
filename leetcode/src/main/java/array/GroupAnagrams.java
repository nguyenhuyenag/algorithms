package array;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Cho mảng các từ, nhóm các anagram lại với nhau:
 *
 * ["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    /**
     * 'aet' và 'ate' có cùng mảng đánh dấu -> có cùng hashCode()
     */
    public int anagramOf(String s) {
        int[] mark = new int[26];
        for (char c : s.toCharArray()) {
            mark[c - 'a']++;
        }
        return Arrays.hashCode(mark);
    }

    public List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> result = new ArrayList<>();
        /**
         * Nhóm lại theo index:
         *      {aet=[0, 1, 3], abt=[5], ant=[2, 4]}
         *      {aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
         */
        Map<Integer, List<String>> groupMap = new HashMap<>();
        for (String word : words) {
            int val = anagramOf(word);
            groupMap.computeIfAbsent(val, k -> new ArrayList<>()).add(word);
        }
        // System.out.println("groupMap = " + groupMap);
        result.addAll(groupMap.values());
        return result;
    }

    @Test
    public void test() {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr);
    }

    //    public String anagramOf(String s) {
//        StringBuilder result = new StringBuilder();
//        int[] mark = new int[26];
//        for (char c : s.toCharArray()) {
//            mark[c - 'a']++;
//        }
//        for (int i = 0; i < mark.length; i++) {
//            if (mark[i] > 0) {
//                char ch = (char) (i + 'a');
//                result.append(String.valueOf(ch).repeat(mark[i]));
//            }
//        }
//        return result.toString();
//    }

    //    public List<List<String>> groupAnagrams(String[] words) {
//        List<List<String>> result = new ArrayList<>();
//
//        /**
//         * Nhóm lại theo index:
//         *      {aet=[0, 1, 3], abt=[5], ant=[2, 4]}
//         *      {aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
//         */
//        Map<String, List<String>> groupMap = new HashMap<>();
//        for (String word : words) {
//            String anagram = anagramOf(word);
//            groupMap.computeIfAbsent(anagram, k -> new ArrayList<>()).add(word);
//        }
//        // System.out.println("groupMap = " + groupMap);
//        result.addAll(groupMap.values());
//        return result;
//    }

//    public List<List<String>> groupAnagrams_OK(String[] words) {
//        List<List<String>> result = new ArrayList<>();
//
//        /**
//         * Tìm anagram của từng phần tử: <index, anagram>
//         * {0=aet, 1=aet, 2=ant, 3=aet, 4=ant, 5=abt}
//         */
//        Map<Integer, String> anagramMap = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            anagramMap.put(i, anagramOf(words[i]));
//        }
//
//        /** Nhóm lại theo index: {aet=[0, 1, 3], abt=[5], ant=[2, 4]}
//         */
//        Map<String, List<Integer>> groupMap = new HashMap<>();
//        for (Map.Entry<Integer, String> entry : anagramMap.entrySet()) {
//            String value = entry.getValue();
//            groupMap.computeIfAbsent(value, k -> new ArrayList<>()).add(entry.getKey());
//        }
//
//        // Lấy kết quả
//        for (List<Integer> indices : groupMap.values()) {
//            List<String> subList = new ArrayList<>();
//            for (int index : indices) {
//                subList.add(words[index]);
//            }
//            result.add(subList);
//        }
//        System.out.println("groupMap = " + groupMap);
//        return result;
//    }

//    public List<List<String>> groupAnagrams(String[] A) {
//        int n = A.length;
//        int[] mark = new int[n];
//        Arrays.fill(mark, 0);
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (mark[i] == 0) {
//                List<String> ls = new ArrayList<>();
//                ls.add(A[i]);
//                for (int j = i + 1; j < n; j++) {
//                    if (mark[j] == 0) {
//                        if (isAnagram(A[i], A[j])) {
//                            ls.add(A[j]);
//                            mark[j] = 1;
//                        }
//                    }
//                }
//                result.add(ls);
//            }
//            mark[i] = 1;
//        }
//        return result;
//    }

    //	public static boolean isAnagram(String s, String t) {
//		int n = s.length();
//		if (n != t.length())
//			return false;
//		char[] arrs = s.toCharArray();
//		char[] arrt = t.toCharArray();
//		Arrays.sort(arrs);
//		Arrays.sort(arrt);
//		for (int i = 0; i < n; i++) {
//			if (arrs[i] != arrt[i]) {
//				return false;
//			}
//		}
//		return true;
//	}

}
