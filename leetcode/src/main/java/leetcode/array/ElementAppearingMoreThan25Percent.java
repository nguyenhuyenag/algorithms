package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
public class ElementAppearingMoreThan25Percent {

	public static int findSpecialInteger(int[] nums) {
		int threshold = nums.length / 4; // 25% của nums
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
		findSpecialInteger(new int[] { 1, 1 });
		// findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 });
	}

//	@org.junit.jupiter.api.Test
//	public void test() {
//		// assertEquals("", largestGoodInteger("101010"));
//	}

}
