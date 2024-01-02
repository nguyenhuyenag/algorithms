package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 *
 * Chia một mảng thành các mảng con sao cho các phần tử trong các mảng con không
 * trùng nhau
 * 
 * [1,3,4,1,2,3,1] -> [[1,3,4,2],[1,3],[1]]
 */
public class LeetMain {

	public List<List<Integer>> findMatrix(int[] nums) {
		Set<Integer> keys = new HashSet<>();
		List<List<Integer>> ans = new ArrayList<>();

		// Đếm
		Map<Integer, Integer> numCount = new HashMap<>();
		for (int e : nums) {
			keys.add(e);
			numCount.put(e, numCount.getOrDefault(e, 0) + 1);
		}

		while (!numCount.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			for (int key : keys) {
				int value = numCount.getOrDefault(key, 0);
				if (value > 0) {
					row.add(key);
					if (value == 1) {
						numCount.remove(key);
					} else {
						numCount.put(key, value - 1);
					}
				}
			}
			ans.add(row);
		}

		return ans;
	}

	@Test
	public void testSomething() {
		findMatrix(new int[] { 1, 3, 4, 1, 2, 3, 1 });
		// findMatrix(new int[] { 1,2,3,4 });
	}

}