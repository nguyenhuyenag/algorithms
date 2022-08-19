package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/
public class AnagramsGroup {

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

	public static List<List<String>> groupAnagrams(String[] A) {
		int n = A.length;
		int[] mark = new int[n];
		Arrays.fill(mark, 0);
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (mark[i] == 0) {
				List<String> ls = new ArrayList<>();
				ls.add(A[i]);
				for (int j = i + 1; j < n; j++) {
					if (mark[j] == 0) {
						if (isAnagram(A[i], A[j])) {
							ls.add(A[j]);
							mark[j] = 1;
						}
					}
				}
				result.add(ls);
			}
			mark[i] = 1;
		}
		return result;
	}

	public static void main(String[] args) {
		String[] arr = { "a" };
		// String[] arr = { "" };
		// String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(arr).toString());
	}

}
