package com.array;

// Tìm tổng lớn nhất của một chuỗi con liên tiếp trong mảng một chiều.
public class MaxSubArray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_end = Integer.MIN_VALUE, max_current = 0;
		for (int i = 0; i < size; i++) {
			max_current = max_current + a[i];
			if (max_end < max_current)
				max_end = max_current;
			if (max_current < 0)
				max_current = 0;
		}
		return max_end;
	}

}
