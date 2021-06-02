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

	public static void permute(char[] arr, int start, int n) {
		if (start == n) {
			System.out.println(new String(arr));
		} else {
			for (int i = start; i <= n; i++) {
				swap(arr, start, i);
				permute(arr, start + 1, n);
				swap(arr, start, i);
			}
		}
	}

	public static void main(String[] args) {
		String str = "123";
		char[] arr = str.toCharArray();
		permute(arr, 0, str.length() - 1);
	}
}
