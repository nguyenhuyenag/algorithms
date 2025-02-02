package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class SortByIncreasingFrequency {

	public static int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		List<Entry<Integer, Integer>> list = map.entrySet().stream() //
				.sorted((a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue()) //
				.collect(Collectors.toList());
		int j = 0;
		int[] arr = new int[nums.length];
		for (Entry<Integer, Integer> e : list) {
			for (int i = 0; i < e.getValue(); i++) {
				arr[j++] = e.getKey();
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3 };
		// int[] nums = { 2, 3, 1, 3, 2 };
		frequencySort(nums);
	}

}
