package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class MainLeet {

    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        while (l < r) {

        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(1, maxArea(new int[]{1, 1}));
        assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
