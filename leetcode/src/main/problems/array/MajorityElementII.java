package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * Đếm số phần tử xuất hiện nhiều hơn [n/3] trong mảng
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int val : nums) {
			map.compute(val, (character, count) -> count == null ? 1 : ++count);
			// map.put(val, map.getOrDefault(val, 0) + 1);
		}
		int quot = nums.length / 3;
		map.forEach((k, v) -> {
			if (v > quot) {
				ans.add(k);
			}
		});
		return ans;
	}

	@Test
	public void test() {
		// assertEquals(Arrays.asList(3), );
		majorityElement(new int[] { 3, 2, 3 });
	}

}
