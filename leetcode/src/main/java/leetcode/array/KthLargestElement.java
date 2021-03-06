package leetcode.array;

import java.util.Arrays;

/*-
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
	
	public static int findKthLargest(int[] A, int k) {
		Arrays.sort(A); 	// sap xep mang
		int n = A.length;
		for (int i = 0; i < n / 2; i++) { // dao mang
			int tmp = A[i];
			A[i] = A[n - 1 - i];
			A[n - 1 - i] = tmp;
		}
		return A[k - 1]; // 0 la vi tri thu 1
	}

}
