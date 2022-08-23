package leetcode.incomplete;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 * 
 * Cho mảng số nguyên A[n] -> tạo mảng mới thỏa mãn giá trị tại vị trí i bằng tích của các vị trị khác i
 *
 */
public class ProductOfArrayExceptSelf {

	public static int mul(int[] A, int len, int index) {
		int result = 1;
		for (int i = 0; i < len; i++) {
			if (i != index) {
				result *= A[i];
			}
		}
		return result;
	}

	public static int[] productExceptSelf(int[] nums) {
		int temp = 1;
		int n = nums.length;
		for (int x : nums) {
			temp *= x;
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = temp != 0 ? temp / nums[i] : mul(nums, n, i);
		}
		return result;
	}

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3, 4 };
		int[] arr = { -1, 1, 0, -3, 3 };
		System.out.println(Arrays.toString(productExceptSelf(arr)));
	}

}
