package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */
public class MainLeet {

    public boolean check(int[] nums) {
        // Find break point
        for (int i = 0; i < nums.length - 1; i++) {
            
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true, check(new int[]{3, 4, 5, 1, 2}));
    }

}
