package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
 */
public class ElementAppearingMoreThan25Percent {

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
		ElementAppearingMoreThan25Percent m = new ElementAppearingMoreThan25Percent();
		// m.findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 });
		m.findSpecialInteger(new int[] { 1, 1 });
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
