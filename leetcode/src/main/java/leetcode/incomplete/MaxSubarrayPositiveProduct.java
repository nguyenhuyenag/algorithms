package leetcode.incomplete;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*-
 * Given an array of integers nums, find the maximum length of a subarray where
 * the product of all its elements is positive.
 * 
 * A subarray of an array is a consecutive sequence of zero or more values taken
 * out of that array.
 * 
 * Return the maximum length of a subarray with positive product.
 * 
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */
public class MaxSubarrayPositiveProduct {

	public static boolean check(int[] A, int start, int end) {
		long res = 1;
		for (int i = start; i <= end; i++) {
			res *= A[i];
		}
		return res > 0;
	}

	public int getMaxLen(int[] A) {
		int max = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= i; j--) {
				if (check(A, i, j)) {
					max = Math.max(max, j - i + 1);
					break;
				}
			}
		}
		return max;
	}

	@Test
	public void test() {
		// assertEquals(4, getMaxLen(new int[] { 1, -2, -3, 4 }));
		// assertEquals(3, getMaxLen(new int[] { 0, 1, -2, -3, -4 }));
		// assertEquals(1, getMaxLen(new int[] { -1, 2 }));
		// assertEquals(4, getMaxLen(new int[] { 1, 2, 3, 5, -6, 4, 0, 10 }));
		// assertEquals(2, getMaxLen(new int[] { 1000000000, 1000000000 }));
		assertEquals(14,
				getMaxLen(new int[] { 70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29,
						32, 59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59, -24, 85, 45,
						-81, 56, 86 }));
	}

}
