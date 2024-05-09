package string;

public class ReverseString {

	public static String reverseString0(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static String reverseString1(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverseString1(str.substring(1)) + str.charAt(0);
	}

	public static String reverseString2(String original) {
		char[] chars = original.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String str = "Java";
		System.out.println(reverseString1(str));
		System.out.println(reverseString2(str));
		System.out.println(new StringBuilder(str).reverse());
	}
}
