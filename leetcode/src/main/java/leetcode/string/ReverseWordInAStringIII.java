package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * "Let's take LeetCode contest" -> "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordInAStringIII {

	public static String reverse(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			builder.append(str.charAt(i));
		}
		return builder.toString();
	}
	
	public String reverseWords2(String str) {
		StringBuilder builder = new StringBuilder();
		for (String s : str.split(" ")) {
			builder.append(reverse(s)).append(" ");
		}
		return builder.toString().trim();
	}

	public static String reverseWords(String str) {
		String[] arr = str.split(" ");
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = reverse(arr[i]);
		}
		return String.join(" ", arr);
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

}
