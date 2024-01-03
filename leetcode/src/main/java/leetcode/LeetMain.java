package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class LeetMain {

    public boolean isPossibleDivide(int[] nums, int k) {
        List<List<Integer>> lists = splitArray(nums, k);
        return lists != null;
    }

    public static List<List<Integer>> splitArray(int[] nums, int k) {
        if (nums.length % k != 0) {
            // System.out.println("The array cannot be divided into sets of size k");
            return null;  // The array cannot be divided into sets of size k
        }

        Arrays.sort(nums);  // Sort the array

        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> numFrequency = new HashMap<>();

        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (numFrequency.get(num) > 0) {
                List<Integer> currentSet = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;

                    if (numFrequency.getOrDefault(nextNum, 0) > 0) {
                        currentSet.add(nextNum);
                        numFrequency.put(nextNum, numFrequency.get(nextNum) - 1);
                    } else {
                        return null;  // The array cannot be divided into sets of size k
                    }
                }
                results.add(currentSet);
            }
        }
        // System.out.println("result = " + Arrays.toString(results.toArray()));
        return results;
    }

    @Test
    public void testSomething() {
        // [1,2,3,4], [3,4,5,6]
        assertEquals(true, isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        // [1,2,3] , [2,3,4] , [3,4,5], [9,10,11]
        assertEquals(true, isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        // false
        assertEquals(false, isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
    }

}
