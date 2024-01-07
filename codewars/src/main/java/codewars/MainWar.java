package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public int adjacentElementsProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] * nums[i + 1]);
        }
        return max;
    }

    private void test(int expected, int actual) {
        assertEquals(expected, actual);
    }

    @Test
    public void fixedTests() {
        test(40, adjacentElementsProduct(new int[]{5, 8}));
        test(6, adjacentElementsProduct(new int[]{1, 2, 3}));
        test(90, adjacentElementsProduct(new int[]{1, 5, 10, 9}));
        test(48, adjacentElementsProduct(new int[]{4, 12, 3, 1, 5}));
        test(6, adjacentElementsProduct(new int[]{5, 1, 2, 3, 1, 4}));

        test(21, adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}));
        test(50, adjacentElementsProduct(new int[]{9, 5, 10, 2, 24, -1, -48}));
        test(30, adjacentElementsProduct(new int[]{5, 6, -4, 2, 3, 2, -23}));
        test(-14, adjacentElementsProduct(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921}));
        test(6, adjacentElementsProduct(new int[]{5, 1, 2, 3, 1, 4}));

        test(0, adjacentElementsProduct(new int[]{1, 0, 1, 0, 1000}));
        test(6, adjacentElementsProduct(new int[]{1, 2, 3, 0}));
    }

}
