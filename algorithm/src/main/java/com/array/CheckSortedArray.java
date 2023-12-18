package com.array;

import com.util.RandomUtils;

public class CheckSortedArray {

    public static boolean isSortedArray(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
