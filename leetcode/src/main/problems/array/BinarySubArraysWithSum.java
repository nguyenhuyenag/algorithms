package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * Cho mảng nhị phân và số thực k. Tìm mảng con có tổng bằng k
 */
public class BinarySubArraysWithSum {

//    public int numSubarraysWithSum(int[] nums, int s) {
//        // List<int[]> result = new ArrayList<>();
//        int currentSum = 0;
//        Map<Integer, List<Integer>> sumMap = new HashMap<>();
//        for (int index = 0; index < nums.length; index++) {
//            currentSum += nums[index];
//            if (currentSum == s) {
//                // result.add(new int[]{0, index});
//            }
//            if (sumMap.containsKey(currentSum - s)) {
//                List<Integer> indices = sumMap.get(currentSum - s);
//                for (int start : indices) {
//                    // result.add(new int[]{start + 1, index});
//                }
//            }
//            if (!sumMap.containsKey(currentSum)) {
//                sumMap.put(currentSum, new ArrayList<>());
//            }
//            sumMap.get(currentSum).add(index);
//        }
//        return result.size();
//    }

    public int numSubarraysWithSum(int[] nums, int s) {
        List<int[]> result = new ArrayList<>();
        int left = 0, right = 0, sum = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (left <= right && sum > s) {
                sum -= nums[left];
                left++;
            }

            if (sum == s) {
                // Add the subarray and move the left pointer to avoid counting overlapping subarrays
                result.add(new int[]{left, right});
                sum -= nums[left]; // Adjust sum
                left++; // Move left pointer
            }

            right++;
        }
        return result.size();
    }

    @Test
    public void test() {
        assertEquals(4, numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        assertEquals(15, numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
