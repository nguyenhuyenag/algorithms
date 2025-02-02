package array;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) { // n - 2
			int l = i + 1, r = n - 1;
			while (l < r) {
				int diff = nums[i] + nums[l] + nums[r] - target;
				if (diff == 0) {
					return target;
				}
				minDiff = Math.abs(diff) < Math.abs(minDiff) ? diff : minDiff;
				if (diff > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return target + minDiff;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(nums, 2));
	}

}
