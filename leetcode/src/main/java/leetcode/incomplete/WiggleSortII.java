package leetcode.incomplete;

import java.util.Arrays;

/*-
 * Given an integer array A, reorder it such that A[0] < A[1] > A[2] < A[3] > ...
 * 
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {

	public static void wiggleSort(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		int[] sorted = Arrays.copyOf(A, n);
		int j = 0, k = (n + 1) / 2;
		for (int i = n - 1; i >= 0; i--) {
			A[i] = i % 2 == 0 ? sorted[j++] : sorted[k++];
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 6, 1, 5, 1, 4, 0 };
		wiggleSort(A);
		System.out.println(Arrays.toString(A));
	}

}
