package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 * https://leetcode.com/problems/maximum-subarray/
 *
 * https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
 *
 * Cho mảng số nguyên, tìm tổng lớn nhất có thể của các phần từ
 */
public class MaximumSubarraySum {

    /**
     * Thuật toán Kadane
     */
    public static int sequence0(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

//    public static int[] maxSubarray0(int[] arr) {
//        int len = arr.length;
//
//        if (len == 0) {
//            return new int[0];
//        }
//
//        int maxSum = arr[0];
//        int currentSum = arr[0];
//
//        int startIndex = 0, endIndex = 0;
//        int tempStartIndex = 0;
//
//        for (int i = 1; i < len; i++) {
//            int x = arr[i];
//            if (x > currentSum + x) {
//                currentSum = x;
//                tempStartIndex = i;
//            } else {
//                currentSum += x;
//            }
//
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//                startIndex = tempStartIndex;
//                endIndex = i;
//            }
//        }
//        return Arrays.copyOfRange(arr, startIndex, endIndex + 1);
//    }

    public static int[] maxSubarray(int[] arr) {
        int max = arr[0], currentMax = arr[0];
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max + arr[i]) {
                max = arr[i];
                tempStart = i;
            } else {
                max = max + arr[i];
            }

            if (max > currentMax) {
                currentMax = max;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public static int sequence(int[] nums) {
        int[] subarray = maxSubarray(nums);
        // System.out.println("subarray = " + Arrays.toString(subarray));
        return Arrays.stream(subarray).sum();
    }

    @Test
    public void testEmptyArray() throws Exception {
//        assertEquals(0, sequence(new int[]{}));
//        assertEquals(7, sequence(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
//        assertEquals(6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(21, sequence(new int[]{8, -19, 5, -4, 20}));
    }

}
