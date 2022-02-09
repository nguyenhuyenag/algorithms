package com.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {

	// Dùng mảng phụ
	public static int[] reverse(int[] A) {
		int n = A.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = A[n - 1 - i];
		}
		return arr;
	}

	// Không dùng mảng phụ
	public static void reverseInPlace(int[] A) {
		int n = A.length;
		for (int i = 0; i < n / 2; i++) {
			int tmp = A[i];
			A[i] = A[n - 1 - i];
			A[n - 1 - i] = tmp;
		}
	}

	// Dùng IntStream
	public static int[] reverse2(int[] A) {
		int n = A.length;
		return IntStream.range(0, n).map(i -> A[n - 1 - i]).toArray();
	}

	// Chỉ định vị tri cần xoay
	public static int[] reverse3(int[] A) {
		int from = 0, to = A.length;
		return IntStream.range(from, to).map(i -> from - 1 + to - i).map(t -> A[t]).toArray();
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// reverse(A);
		// A = reverse2(A);
		reverseInPlace(A);
		// A = reverse3(A);
		System.out.println(Arrays.toString(A));
	}

}
