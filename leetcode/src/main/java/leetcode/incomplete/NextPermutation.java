package leetcode.incomplete;

import org.junit.Test;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {

	public void nextPermutation(int[] A) {
		int n = A.length;
		if (A == null || n <= 1) {
			return;
		}
		int i = n - 2;
		while (i >= 0 && A[i] >= A[i + 1]) {
			i--; 							// Tìm vị trí không giảm
		}
		if (i >= 0) { 						// có
			int j = n - 1; 					// chạy từ cuối lên
			while (A[i] >= A[j]) {
				j--; 						// Find rightmost first larger id j
			}
			swap(A, i, j); 					// Switch i and j
		}
		reverse(A, i + 1, n - 1); 			// Reverse the descending sequence
	}
	
	public void reverse(int[] A, int i, int j) {
		while (i < j) {
			swap(A, i++, j--);
		}
	}

	public void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	@Test
	public void test() {
		// assertArrayEquals(expecteds, actuals);
		// [1, 2, 3] => [1, 3, 2]
		// [3, 2, 1] => [1, 2, 3]
		// [1, 1, 5] => [1, 5, 1]
		// [1] => [1]
	}

}
