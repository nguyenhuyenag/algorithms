package com.array;

/**
 * Cho mang so nguyen arr va so nguyen target. Tim phan tu gan target nhat
 * 
 * VD: nums = { -1, 2, 1, -4 }, target = 2 => 2
 */
public class FindClosestElement {

	int getClosest(int v1, int v2, int target) {
		if (target - v1 >= v2 - target) {
			return v2;
		}
		return v1;
	}

	public static int nearest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int closest = target;
		for (int x : nums) {
			int diff = Math.abs(x - target);
			if (diff < min) {
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
