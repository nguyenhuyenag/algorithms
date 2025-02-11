package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int x : nums) {
			queue.add(x);
		}
		int max = 0, count = 0;
		int prev = 0;
		if (queue.size() > 0) {
			prev = queue.poll();
			count++;
		}
		while (queue.size() > 0) {
			int curr = queue.poll();
			if (curr == prev) {
				continue;
			}
			if (curr == prev + 1) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 1;
			}
			prev = curr;
		}
		return Math.max(max, count);
	}

	public static void main(String[] args) {
		// int[] nums = { 100, 4, 200, 1, 3, 2 }; // 4
		// int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }; // 9
		// int[] nums = { 0 }; // 1
		// int[] nums = { 1, 2, 0, 1 }; // 3
		int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 }; // 7

		System.out.println(longestConsecutive(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
