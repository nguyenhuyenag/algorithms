package com.array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cho mảng số nguyên, trả về true nếu có phần tử xuất hiện 2 lần
 */
public class CheckDuplicate {

    static boolean duplicates(final int[] zipcodeList) {
        final int MAXZIP = 99999;
        boolean[] bitmap = new boolean[MAXZIP + 1];
        java.util.Arrays.fill(bitmap, false);
        for (int item : zipcodeList) {
            if (!bitmap[item]) bitmap[item] = true;
            else return true;
        }
        return false;
    }

    public boolean containsDuplicate_0(int[] nums) {
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
