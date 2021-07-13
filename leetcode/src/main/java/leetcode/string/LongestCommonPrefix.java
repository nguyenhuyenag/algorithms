package leetcode.string;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		String str_0 = strs[0];
		int len = strs.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str_0.length(); i++) {
			sb.append(str_0.charAt(i));
			for (int j = 1; j < len; j++) {
				if (!strs[j].startsWith(sb.toString())) {
					sb.deleteCharAt(i);
					return sb.toString();
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		// String[] strs = { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix(strs));
	}

}
