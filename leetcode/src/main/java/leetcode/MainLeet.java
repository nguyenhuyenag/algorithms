package leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 */
public class MainLeet {

    public int singleNumber(int[] nums) {
        int key = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (key == nums[i]) {
                key = nums[i];
            }
        }
        return key;
    }

    @Test
    public void test() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, singleNumber(new int[]{1}));
    }

}
