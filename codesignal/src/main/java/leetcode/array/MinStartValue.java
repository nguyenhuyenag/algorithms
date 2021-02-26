package leetcode.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
public class MinStartValue {

	public int minStartValue2(int[] nums) {
		int i, n = nums.length;
		int startValue = 1, sum = 1;
		while (true) {
			for (i = 0; i < n; i++) {
				sum += nums[i];
				if (sum < 1) {
					startValue = startValue + 1 - sum;
					sum = startValue;
					break;
				}
			}
			if (i >= n - 1) {
				return startValue;
			}
		}
	}
	
	public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;
        for (int x: nums) {
            sum += x;
            minSum = Math.min(sum, minSum);
        }
        return 1 - minSum;
    }

	@Test
	public void test() {
		assertEquals(5, minStartValue(new int[] { -3, 2, -3, 4, 2 }));
		assertEquals(1, minStartValue(new int[] { 1, 2 }));
		assertEquals(5, minStartValue(new int[] { 1, -2, -3 }));
	}

}
