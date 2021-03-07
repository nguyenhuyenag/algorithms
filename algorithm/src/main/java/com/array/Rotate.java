package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Chuyển k phần tử đầu tiên về cuối mảng
 */
public class Rotate {

	public static void move(int[] A) {
		int i;
		int tmp = A[0]; // Lưu A[0]
		for (i = 0; i < A.length - 1; i++) {
			A[i] = A[i + 1]; // Dời từng phần tử lên phía trước
		}
		A[i] = tmp; // Gán phần tử cuối cùng là A[0]
	}

	// Chuyển k lần
	public static void rotate(int[] arr, int k) {
		for (int i = 1; i <= k; i++) {
			move(arr);
		}
	}

	public static <T> void moveByCollection(T[] arr, int k) {
		List<T> list = Arrays.asList(arr);
		System.out.println("Before: " + Arrays.toString(arr));
		Collections.rotate(list, k);
		System.out.println("After: " + Arrays.toString(list.toArray()));
	}

	public static void main(String[] args) {
		int k = 3; // chuyển k phần tử
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println("Before:\t" + Arrays.toString(arr));
		rotate(arr, k);
		System.out.println("After:\t" + Arrays.toString(arr));
	}

}
