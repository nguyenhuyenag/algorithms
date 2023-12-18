package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 *
 * Số may mắn (lucky number) là số mà số lần xuất hiện của nó bằng chính nó
 */
public class FindLuckyNumberInArray {

    public int findLucky(int[] arr) {
        int maxFrequency = -1;
        Map<Integer, Integer> charCount = new HashMap<>();
        for (int x : arr) {
            charCount.put(x, charCount.getOrDefault(x, 0) + 1);
        }
        // System.out.println(charCount);
        for (Map.Entry<Integer, Integer> e : charCount.entrySet()) {
            if (e.getKey().equals(e.getValue())) {
                maxFrequency = Math.max(maxFrequency, e.getKey());
            }
        }
        return maxFrequency;
    }

    @Test
    public void doTest() {
        assertEquals(2, findLucky(new int[]{2, 2, 3, 4}));
        assertEquals(-1, findLucky(new int[]{2, 2, 2, 3, 3}));
        assertEquals(3, findLucky(new int[]{1, 2, 2, 3, 3, 3}));
    }

}
