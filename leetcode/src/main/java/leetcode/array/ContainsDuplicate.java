package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Input: nums = [1,2,3,1], Output: true
 * 
 * Input: nums = [1,2,3,4], Output: false
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			if (!set.add(x)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
