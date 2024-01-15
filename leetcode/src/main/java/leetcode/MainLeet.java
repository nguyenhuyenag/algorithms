package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class MainLeet {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target && nums[r] == target) {
                return new int[]{l, r};
            } else if (nums[l] < target) {
                l++;
            } else if (nums[r] > target) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

}
