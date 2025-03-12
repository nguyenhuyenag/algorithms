package test;

import org.junit.jupiter.api.Disabled;
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

    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }

    @Test
    public void test1() {
        assertEquals(3, maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
    }

    @Test
    public void test2() {
        assertEquals(3, maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }

}
