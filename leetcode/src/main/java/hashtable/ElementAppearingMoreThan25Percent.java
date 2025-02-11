package hashtable;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Tìm phần tử xuất hiện > 25% số các phần tử
 */
public class ElementAppearingMoreThan25Percent {

    public static int findSpecialInteger(int[] nums) {
        int threshold = nums.length / 4; // 25% của nums
		// Counter
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
		// Tim phần tử thỏa mãn yêu cầu
		for (int num : counter.keySet()) {
			if (counter.get(num) > threshold) {
				return num;
			}
		}
        return -1;
    }

    @Test
    public void test() {
        assertEquals(6, findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }

}
