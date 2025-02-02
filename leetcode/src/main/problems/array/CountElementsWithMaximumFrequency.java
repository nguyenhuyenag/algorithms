package array;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/count-elements-with-maximum-frequency/

    Cho mảng số nguyên, tính tổng số lần xuất hiện nhiều nhất của phần tử.

    Ví dụ: arr = [1, 2, 2, 3, 1, 4] -> Phần tử xuất hiện nhiều nhất là {1=2, 2=2} -> 2 + 2 = 4
 */
public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements_1(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        Collection<Integer> values = counter.values();
        int maxFrequency = Collections.max(values);
        return values.stream()
                .filter(t -> t == maxFrequency)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int maxFrequencyElements_best(int[] nums) {
        int maxFrequency = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            // Tìm max trong quá trình counter
            maxFrequency = Math.max(maxFrequency, counter.get(num));
        }
        Collection<Integer> values = counter.values();
        int countFrequency = Collections.frequency(values, maxFrequency);
        return maxFrequency * countFrequency;
    }

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        Collection<Integer> values = counter.values();
        // Tìm giá trị lớn nhất của số lần xuất hiện
        int maxFrequency = Collections.max(values);

        // Đếm số lần xuất hiện của maxFrequency
        int countFrequency = Collections.frequency(values, maxFrequency);

        return maxFrequency * countFrequency;
    }

    @Test
    public void test() {
        assertEquals(4, maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }
}
