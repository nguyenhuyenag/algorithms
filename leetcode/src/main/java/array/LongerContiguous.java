package array;

/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros
 * 
 * Xem thêm MaxConsecutiveOnes.java
 */
public class LongerContiguous {
	
	public int findMaxConsecutiveOnes(char[] nums, char bit) {
		int max = 0, count = 0;
		for (char c : nums) {
			if (c == bit) {
				count++;
				max = Math.max(count, max);
			} else {
				count = 0;
			}
		}
		return max;
    }

	 public boolean checkZeroOnes(String s) {
		char[] arr = s.toCharArray();
		return findMaxConsecutiveOnes(arr, '1') > findMaxConsecutiveOnes(arr, '0');
	}

}
