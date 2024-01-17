package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Đếm số lần xuất hiện của các phần tử trong mảng, trả về true nếu chúng là duy nhất
 *
 *  [1, 2, 2, 1, 1, 3]  -> {1=3, 2=2,3=1} -> [3,2,1] -> true
 *  [1, 1, 2, 2, 3]     -> {1=2, 2=2,3=1} -> [2,2,1] -> false
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueCounts = new HashSet<>(countMap.values());
        return uniqueCounts.size() == countMap.size();
    }

    @Test
    public void test() {
        assertEquals(true, uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        assertEquals(false, uniqueOccurrences(new int[]{1, 2}));
        assertEquals(true, uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

}
