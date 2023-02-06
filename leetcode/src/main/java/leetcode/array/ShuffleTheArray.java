package leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*-
 * https://leetcode.com/problems/shuffle-the-array/description/
 * 
 * Given the array nums consisting of 2n elements in the form: [x1,x2,...,xn,y1,y2,...,yn].
 * 
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn]
 */
public class ShuffleTheArray {

	public int[] shuffle(int[] nums, int n) {
		int j = 0;
		int[] result = new int[2 * n];
		for (int i = 0; i < n; i++) {
			result[j++] = nums[i];
			result[j++] = nums[n + i];
		}
		return result;
	}

	public int[] officialProof(int[] nums, int n) {
		int[] result = new int[2 * n];
		for (int i = 0; i < n; ++i) {
			result[2 * i] = nums[i];
			result[2 * i + 1] = nums[n + i];
		}
		return result;
	}

	@Test
	public void test1() {
		int[] nums = { 2, 5, 1, 3, 4, 7 };
		assertArrayEquals(new int[] { 2, 3, 5, 4, 1, 7 }, shuffle(nums, 3));
	}

	@Test
	public void test2() {
		int[] nums = { 1, 2, 3, 4, 4, 3, 2, 1 };
		assertArrayEquals(new int[] { 1, 4, 2, 3, 3, 2, 4, 1 }, shuffle(nums, 4));
	}

	@Test
	public void test3() {
		int[] nums = { 1, 1, 2, 2 };
		assertArrayEquals(new int[] { 1, 2, 1, 2 }, shuffle(nums, 2));
	}

}
