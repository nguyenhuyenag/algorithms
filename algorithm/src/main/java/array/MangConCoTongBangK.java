package array;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 */
public class MangConCoTongBangK {

    public List<int[]> numSubarraysWithSum(int[] nums, int s) {
        List<int[]> result = new ArrayList<>();
        int currentSum = 0;
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            currentSum += nums[index];
            if (currentSum == s) {
                result.add(new int[]{0, index});
            }
            if (sumMap.containsKey(currentSum - s)) {
                List<Integer> indices = sumMap.get(currentSum - s);
                for (int start : indices) {
                    result.add(new int[]{start + 1, index});
                }
            }
            if (!sumMap.containsKey(currentSum)) {
                sumMap.put(currentSum, new ArrayList<>());
            }
            sumMap.get(currentSum).add(index);
        }
        return result;
    }

    public int subarraySum0(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == k) {
                    // printSubarray(arr, i, j, k);
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j + 1)));
                    count++;
                }
            }
        }
        return count;
    }

    // findSubArrayWithSumk
//    public int subarraySum(int[] arr, int s) {
//        int count = 0;
//        int left = 0, right = 0, currentSum = 0;
//        while (right < arr.length) {
//            currentSum += arr[right];
//            while (currentSum > s && left <= right) {
//                currentSum -= arr[left];
//                left++;
//            }
//            if (currentSum == s) {
//                int[] subArray = Arrays.copyOfRange(arr, left, right + 1);
//                if (subArray.length > 0) {
//                    System.out.println(Arrays.toString(subArray));
//                    count++;
//                }
//            }
//            right++;
//        }
//        return count;
//    }

    public int findSubArraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, List<Integer>> sumIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            // Check if the current subarray sum is equal to k
            if (currentSum == k) {
                // result.add(Arrays.copyOfRange(nums, 0, i + 1));
                count++;
            }
            // Check if there is a previous subarray with sum (currentSum - k)
            if (sumIndicesMap.containsKey(currentSum - k)) {
                for (int j : sumIndicesMap.get(currentSum - k)) {
                    // result.add(Arrays.copyOfRange(nums, j + 1, i + 1));
                    count++;
                }
            }
            // Update the map with the current sum and its index
            sumIndicesMap.computeIfAbsent(currentSum, key -> new ArrayList<>()).add(i);
        }
        return count;
    }

    public int subarraySum(int[] arr, int k) {
        return findSubArraySum(arr, k);
    }

    @Test
    public void test() {
        assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
        assertEquals(0, subarraySum(new int[]{1}, 0));
        assertEquals(1, subarraySum(new int[]{-1, -1, 1}, 0));
        assertEquals(3, subarraySum(new int[]{1, -1, 0}, 0));
    }

}
