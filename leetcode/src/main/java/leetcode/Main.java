package leetcode;

public class Main {

	public static String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		String t = strs[0];
		while (i < t.length()) {
			sb.append(t.charAt(i));
			for (int j = 1; j < strs.length; j++) {
				if (!strs[j].startsWith(sb.toString())) {
					sb.deleteCharAt(i);
					return sb.toString();
				}
			}
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// String[] strs = {"flower","flow","flight"};
		String[] strs = { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix(strs));
	}

}
