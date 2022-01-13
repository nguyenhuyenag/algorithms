package com.array;

/**
 * Cho mang so nguyen arr va so nguyen k. Tim phan tu gan k nhat
 * 
 * VD: nums = { -1, 2, 1, -4 }, va k = 2. Ta co kq = 2
 */
public class FindClosestElement {

	int getClosest(int v1, int v2, int k) {
		if (k - v1 >= v2 - k) {
			return v2;
		}
		return v1;
	}

	public static int nearest(int[] nums, int k) {
		int min = Integer.MAX_VALUE;
		int closest = k;
		for (int x : nums) {
			int diff = Math.abs(x - k);
			if (min > diff) {
				min = diff;
				closest = x;
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(nearest(nums, -6));
	}

}
