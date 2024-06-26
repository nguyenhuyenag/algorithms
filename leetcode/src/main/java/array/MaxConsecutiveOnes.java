package array;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
	
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, count = 0;
		for (int x : nums) {
			if (x == 1) {
				count++;
				max = Math.max(count, max);
			} else {
				count = 0;
			}
		}
		return max;
    }

}
