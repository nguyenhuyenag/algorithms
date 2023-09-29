package leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * - https://leetcode.com/problems/monotonic-array/description/
 * 
 * - Kiểm tra mảng đơn điệu (tăng dần hoặc, giảm dần)
 */
public class MonotonicArray {

	public boolean isMonotonic2(int[] nums) {
		return isMonotonicHelper(nums, true) || isMonotonicHelper(nums, false);
	}

	private boolean isMonotonicHelper(int[] nums, boolean increasing) {
		for (int i = 1; i < nums.length; i++) {
			int comparison = Integer.compare(nums[i - 1], nums[i]);
			if (comparison == 0) {
				continue; // Skip equal elements
			}
			if (increasing && comparison > 0) {
				return false;
			}
			if (!increasing && comparison < 0) {
				return false;
			}
		}
		return true;
	}

	// Check tang dan
	public boolean checkIMonotonic(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int v : nums) {
			stack.add(v);
		}
		int pre = stack.pop();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (pre > cur) {
				return false;
			}
			pre = cur;
		}
		return true;
	}

	// Check giam dan
	public boolean checkDMonotonic(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int v : nums) {
			stack.add(v);
		}
		int pre = stack.pop();
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (pre < cur) {
				return false;
			}
			pre = cur;
		}
		return true;
	}

	public boolean isMonotonic(int[] nums) {
		return checkIMonotonic(nums) | checkDMonotonic(nums);
	}

	@Test
	public void test() {
		// assertEquals(true, isMonotonic(new int[] { 1, 2, 2, 3 }));
		// assertEquals(true, isMonotonic(new int[] { 6, 5, 4, 4 }));
		assertEquals(false, isMonotonic(new int[] { 1, 3, 2 }));
	}

}
