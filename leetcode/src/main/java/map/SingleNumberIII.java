package map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/single-number-iii/
 *
 * Tìm các số xuất hiện duy nhất trong mảng.
 */
public class SingleNumberIII {

    public int[] singleNumber_OK(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        return counter.keySet()
                .stream()
                .filter(key -> counter.get(key) == 1)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 5}, singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }

}
