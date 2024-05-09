package array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Cho mảng số nguyên, trả về true nếu có phần tử xuất hiện 2 lần
 */
public class ContainsDuplicate {

    public boolean containsDuplicate0(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true, containsDuplicate(new int[]{1, 2, 3, 1}));
        assertEquals(true, containsDuplicate(new int[]{1, 0, 1, 1}));
        assertEquals(true, containsDuplicate(new int[]{1, 2, 3, 1, 2, 3}));
        assertEquals(false, containsDuplicate(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
