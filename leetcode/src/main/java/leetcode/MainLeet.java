package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }

    @Test
    public void test() {
        assertEquals(2, findMaxLength(new int[]{0, 1}));
        // assertEquals(2, findMaxLength(new int[]{0, 1, 0}));
    }

}
