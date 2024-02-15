package com.util;

import java.util.Arrays;

public class PrintAllArrayWithOutLoop {

	public static void rotate(int[] A, int n) {
		if (n >= 0) {
			System.out.println(A[n]);
			rotate(A, n - 1);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		rotate(A, A.length - 1);
		System.out.println("A = " + Arrays.toString(A));
	}

}
