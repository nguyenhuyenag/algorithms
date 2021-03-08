package com.array;

public class FindMaxWithoutLoop {

	public static int findMax(int[] A, int len) {
		if (len == 0) {
			return A[0];
		}
		int max = A[len - 1];
		return Math.max(max, findMax(A, len - 1));
	}

	public static void main(String[] args) {
		int[] arr = { -9, 0, 12, 8, -22, 0, 0 };
		System.out.println(findMax(arr, arr.length));
	}

}
