package leetcode.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/single-number/
 * <p>
 * Tìm số xuất hiện duy nhất trong mảng
 */
public class SingleNumber {

    public int singleNumber_OK(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int num : counter.keySet()) {
            if (counter.get(num) == 1) return num;
        }
        return -1;
    }

    // If a = b -> a^b = 1
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(2, singleNumber(new int[]{1, 1, 2}));
    }

}
