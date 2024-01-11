package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Chủ đề: Two pointer, in-place algorithm
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Dời các phần tử bằng 0 về cuối mảng, không dùng mảng phụ
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int pointer = 0;
		int len = nums.length;

		// Dời các phần tử khác không về đầu mảng
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				nums[pointer++] = nums[i];
			}
		}

		// Đánh dấu các phần tử còn lại là 0
		for (int i = pointer; i < len; i++) {
			nums[i] = 0;
		}
	}

	@Test
	public void test() {
		// int[] arr = {0};
		// int[] arr = {1};
		// int[] arr = {0, 1, 0, 3, 12};
		int[] arr = {0, 0, 1};
		System.out.println(Arrays.toString(arr));
		moveZeroes(arr);
		// moveByIndex(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

}
