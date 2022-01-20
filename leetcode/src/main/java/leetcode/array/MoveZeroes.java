package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

	public static void move(int[] A, int k) {
		int i;
		int tmp = A[k];
		for (i = k; i < A.length - 1; i++) {
			A[i] = A[i + 1];
		}
		A[i] = tmp;
	}

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0 && i != n - 1) {
				count++;
			}
		}
		for (int i = 1; i <= count; i++) {
			for (int j = 0; j < n; j++) {
				if (nums[j] == 0) {
					move(nums, j);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		// int[] nums = { 0 };
		// int[] nums = { 0, 0, 1 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

}
