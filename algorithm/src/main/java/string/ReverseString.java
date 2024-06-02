package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
	https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public void reverseString_0(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = tmp;
        }
    }

    public void reverseString(char[] arr) {
        int l = 0, r = arr.length - 1;
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
        char[] arr = "Java".toCharArray();
        reverseString(arr);
        assertArrayEquals(new char[]{'a', 'v', 'a', 'J'}, arr);
    }

//        public String reverseString_0(String str) {
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

}
