package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 */
public class MainLeet {

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
