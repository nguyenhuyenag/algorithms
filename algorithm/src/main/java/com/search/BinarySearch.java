package com.search;

import java.util.Arrays;

public class BinarySearch {

	// array in ascending order
	public static int binarySearch(int[] A, int key) {
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == key) {
				return m;
			}
			if (A[m] < key) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1; // key not found
	}

	public static void main(String[] args) {
		int[] A = { 1, -9, 6, 11, 21, 6, 7, 90, 9, 1 };
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		System.out.println(binarySearch(A, 11));
	}

}
