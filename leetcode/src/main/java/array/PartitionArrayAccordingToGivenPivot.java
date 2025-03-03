package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    https://leetcode.com/problems/partition-array-according-to-given-pivot/

    Cho mảng số nguyên và số pivot.
        - Nếu số x < pivot thì dời nó qua trái pivot
        - Nếu x > pivot thì dời nó qua phải
        - Vẫn đảm bảo thứ tự của các số trong mảng
 */
public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int p = 0;
        int len = nums.length;
        int[] result = new int[len];
        // Handle nums[i] < pivot
        for (int num : nums) {
            if (num < pivot) {
                result[p++] = num;
            }
        }
        // Handle nums[i] == pivot
        for (int num : nums) {
            if (num == pivot) {
                result[p++] = num;
            }
        }
        // Handle nums[i] > pivot
        for (int num : nums) {
            if (num > pivot) {
                result[p++] = num;
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
