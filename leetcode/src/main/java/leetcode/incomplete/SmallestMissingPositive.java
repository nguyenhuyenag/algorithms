package leetcode.incomplete;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class SmallestMissingPositive {

	public int firstMissingPositive(int[] A) {
		boolean flag = false;
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		// tim so duong nho nhat
		int minpositive = -1, n = A.length;
		// tim so duong nho nhat trong mang
		for (int i = 0; i < n; i++) {
			if (A[i] > 0) {
				minpositive = A[i];
				flag = true;
				break;
			}
		}
		if (!flag) { // all A[i] < 0
			return 1;
		}
		if (minpositive > 1) { // 2, 3, ...
			return 1;
		}
		// int i;
		for (int i = 0; i < n - 1; i++) { // [0, n - 2]
			if (A[i] > 0) {
				if (A[i + 1] != A[i] + 1) {
					minpositive = A[i] + 1;
				} else {
					minpositive = A[i + 1] + 1;
				}
			}
		}
		return minpositive;
	}

	@Test
	public void test() {
		// assertEquals(1, firstMissingPositive(new int[] { 7, 8, 9, 11, 12 })); // left
		// assertEquals(1, firstMissingPositive(new int[] { 2, 3, 7, 6, 8, -1, 9 })); // left

		// assertEquals(4, firstMissingPositive(new int[] { 2, 3, -7, 6, 8, 1, -10, 15 })); // right
		// assertEquals(3, firstMissingPositive(new int[] { 1, 2, 0 })); // right
		// assertEquals(2, firstMissingPositive(new int[] { 3, 4, -1, 1 })); // right
		
		assertEquals(2, firstMissingPositive(new int[] { 1 })); // right
		// assertEquals(3, firstMissingPositive(new int[] { 0, 1, 1, 2, 2 })); // right
	}

}
