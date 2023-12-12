package leetcode.array;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * 
 * (A - 1)*(B - 1) = max => A * B = max => max * secondMax = ans
 */
public class MaximumProductOfTwoElements {

	/**
	 * Sử dụng hàng đợi ưu tiên để thêm -x phần tử, khi đó phần tử đầu tiên là phần
	 * tử lớn nhất
	 */
	public int[] getTwoMaximumValue(int[] nums) {
		int twoMaximumValue[] = { 0, 0 };
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		for (int x : nums) {
			maxHeap.add(-x);
		}

		/**
		 * Lấy ra phần từ lớn nhất và lớn nhì
		 */
		for (int i = 0; i < 2; i++) {
			twoMaximumValue[i] = -maxHeap.remove();
		}
		return twoMaximumValue;
	}

	public int maxProduct0(int[] nums) {
		int[] twoMaximumValue = getTwoMaximumValue(nums);
		return (twoMaximumValue[0] - 1) * (twoMaximumValue[1] - 1);
	}

	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int x : nums) {
			if (x > max) {
				secondMax = max;
				max = x;
			} else if (x > secondMax) {
				secondMax = x;
			}
		}
		return (max - 1) * (secondMax - 1);
	}

	public static void main(String[] args) {
		MaximumProductOfTwoElements m = new MaximumProductOfTwoElements();
		m.maxProduct(new int[] { 3, 7 });
		// m.maxProduct(new int[] { 1,5,4,5 });
		// m.maxProduct(new int[] { 3, 4, 5, 2 });
	}

}
