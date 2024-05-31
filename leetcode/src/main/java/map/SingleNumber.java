package map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/single-number/
 *
 * Cho mảng số nguyên chứa các số xuất hiện 2 lần và một số nguyên xuất hiện 1 lần.
 * Tìm số xuất hiện 1 lần đó.
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

    /*
        Nếu a = b -> a^b = 1.

        Cách này chỉ áp dụng cho bài toán xuất hiện đúng 2 lần.
     */
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
