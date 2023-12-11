package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
public class Main {

	int val = -1;

	public Integer findSpecialInteger(int[] nums) {
		int threshold = nums.length / 4;
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > threshold) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 });
		m.findSpecialInteger(new int[] { 1, 1 });
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
