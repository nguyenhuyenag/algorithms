package com.array;

import java.util.Arrays;

public class ReverseArray {

	public static int[] reverse(int[] A) {
		int n = A.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = A[n - 1 - i];
		}
		return arr;
	}

	public static void reverseInPlace(int[] A) {
		int n = A.length;
		for (int i = 0; i < n / 2; i++) {
			int tmp = A[i];
			A[i] = A[n - 1 - i];
			A[n - 1 - i] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		reverseInPlace(A);
		System.out.println(Arrays.toString(A));
	}

}
