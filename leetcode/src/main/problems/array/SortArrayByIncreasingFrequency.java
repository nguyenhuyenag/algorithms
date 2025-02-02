package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/sort-array-by-increasing-frequency/


 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return Arrays.stream(nums)
                .boxed()
                .sorted((u, v) -> {
                    int compareByFrequency = freq.get(u) - freq.get(v);
                    return compareByFrequency != 0 ? compareByFrequency : v - u;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    public void test() {
        // assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        assertArrayEquals(new int[]{1, 3, 3, 2, 2}, frequencySort(new int[]{2, 3, 1, 3, 2}));
    }

}
