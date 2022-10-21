package leetcode.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateII {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int k = 1;
		int[] nums = { 1, 2, 3, 1, 2, 8, 1 };
		System.out.println(containsNearbyDuplicate(nums, k));
	}
	
}
