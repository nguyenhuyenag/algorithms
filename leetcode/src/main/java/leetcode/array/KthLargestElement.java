package leetcode.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/*-
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
	
	public static int findKthLargest2(int[] A, int k) {
		Arrays.sort(A); 					// sap xep mang
		int n = A.length;
		for (int i = 0; i < n / 2; i++) { 	// dao mang
			int tmp = A[i];
			A[i] = A[n - 1 - i];
			A[n - 1 - i] = tmp;
		}
		return A[k - 1]; // 0 la vi tri thu 1
	}
	
	// Sử dụng hàng đợi ưu tiên
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int el : nums) {
			queue.add(el);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}

	@Test
	public void test() {
		assertEquals(5, findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		assertEquals(4, findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
		assertEquals(2, findKthLargest(new int[] { 2, 1 }, 1));
	}

}
