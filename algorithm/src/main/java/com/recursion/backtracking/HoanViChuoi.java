package com.recursion.backtracking;

/**
 * Cho chuỗi S, liệt kê tất cả các hoán vị của S
 */
public class HoanViChuoi {

	public static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	public static void permute(char[] arr, int left, int right) {
		if (left == right) {
			System.out.println(new String(arr));
		} else {
			for (int i = left; i <= right; i++) {
				swap(arr, left, i);
				permute(arr, left + 1, right);
				swap(arr, left, i);
			}
		}
	}

	public static void main(String[] args) {
		String str = "123";
		char[] arr = str.toCharArray();
		permute(arr, 0, str.length() - 1);
	}
}
