package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 * 
 * Đếm các cặp số thỏa mãn i < j mà nums[i] == nums[j]
 */
public class NumberOfGoodPairs {

	public int numIdenticalPairs_OK(int[] nums) {
		int count = 0;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public int numIdenticalPairs(int[] nums) {
		int ans = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int x : nums) {
			int friendCount = hm.getOrDefault(x, 0);
			ans += friendCount;
			hm.put(x, friendCount + 1);
		}
		return ans;
	}

	@Test
	public void test() {
		// assertEquals(4, numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		assertEquals(6, numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		// assertEquals(0, numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

}
