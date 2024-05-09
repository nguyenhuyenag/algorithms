package array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 *
 */
public class RemoveDuplicatesFromSortedArray {

    // [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] ->  [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
    public int removeDuplicates(int[] nums) {
        // Lọc ra các số duy nhất
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        // Gán kết quả vào mảng nums
        int i = 0;
        for (int u : unique) {
            nums[i++] = u;
        }
        return i;
    }

    @Disabled
    @Test
    public void test1() {
        int[] arr = {1, 1, 2};
        removeDuplicates(arr);
        assertArrayEquals(new int[]{1, 2, 2}, arr);
    }

    @Test
    public void test2() {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4}, arr);
    }

    public int removeDuplicates_OK(int[] nums) {
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

}
