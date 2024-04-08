package com.zother;

import com.util.RandomUtils;

public class FindMaxWithoutLoop {

	public static int findMax(int[] A, int len) {
		if (len == 0) {
			return A[0];
		}
		int max = A[len - 1];
		return Math.max(max, findMax(A, len - 1));
	}

	public static void main(String[] args) {
		int[] arr = RandomUtils.randomArray();
		System.out.println(findMax(arr, arr.length));
	}

}
