package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
	https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

//    public String reverseString_0(String str) {
//        return new StringBuilder(str).reverse().toString();
//    }
//
//    public String reverseString(String str) {
//        if (str.isEmpty()) {
//            return str;
//        }
//        return reverseString(str.substring(1)) + str.charAt(0);
//    }
//
//    public String reverseString_2(String s) {
//        char[] chars = s.toCharArray();
//        int left = 0;
//        int right = chars.length - 1;
//        while (left < right) {
//            char tmp = chars[left];
//            chars[left] = chars[right];
//            chars[right] = tmp;
//            left++;
//            right--;
//        }
//        return new String(chars);
//    }

    public void reverseString_0(char[] arr) {
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[(len - 1) - i];
            arr[(len - 1) - i] = tmp;
        }
    }

	public void reverseString(char[] arr) {
		int l = 0, r = arr.length -1;
		while (l < r) {
			char tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
	}

    @Test
    public void tets() {
        String str = "Java";
		reverseString("Java".toCharArray());
    }
}
