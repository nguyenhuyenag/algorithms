package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
public class AnagramsRemoving {

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

	public static List<String> removeAnagrams(String[] A) {
		int n = A.length;
		int[] mark = new int[n];
		Arrays.fill(mark, 0);
		for (int i = 1; i < n; i++) {
			if (isAnagram(A[i], A[i - 1])) {
				mark[i] = 1;
			}
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (mark[i] == 0) {
				result.add(A[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// String[] arr = { "a", "b", "a" };
		// String[] arr = { "a", "b", "c", "d", "e" };
		String[] arr = { "abba", "baba", "bbaa", "cd", "cd" };
		System.out.println(removeAnagrams(arr).toString());
	}

}
