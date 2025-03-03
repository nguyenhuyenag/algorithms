package test;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    https://leetcode.com/problems/clear-digits/description/

    https://leetcode.com/problems/partition-array-according-to-given-pivot/
 */
public class MainLeet {

    public int[] pivotArray(int[] nums, int pivot) {
        int p = 0;
        int len = nums.length;
        int[] result = new int[len];
        boolean[] mark = new boolean[len];
        // Handle nums[i] < pivot
        for (int i = 0; i < len; i++) {
            if (!mark[i] && nums[i] < pivot) {
                mark[i] = true;
                result[p++] = nums[i];
            }
        }
        // Handle nums[i] = pivot
        for (int i = 0; i < len; i++) {
            if (!mark[i] && nums[i] == pivot) {
                mark[i] = true;
                result[p++] = nums[i];
            }
        }
        // Handle nums[i] > pivot
        for (int i = 0; i < len; i++) {
            if (!mark[i]) {
                // mark[i] = true;
                result[p++] = nums[i];
            }
        }
        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{9, 5, 3, 10, 10, 12, 14}, pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{-3, 2, 4, 3}, pivotArray(new int[]{-3, 4, 3, 2}, 2));
    }

}
