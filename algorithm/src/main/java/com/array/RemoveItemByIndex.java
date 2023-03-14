package com.array;

import java.util.Arrays;

public class RemoveItemByIndex {

	public static int[] remove(int[] arr, int index) {
		int idx = 0;
		int n = arr.length;
		int[] result = new int[n - 1];
		for (int i = 0; i < n; i++) {
			if (i != index) {
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 0;
		arr = remove(arr, k);
		System.out.println(Arrays.toString(arr));
	}

}
