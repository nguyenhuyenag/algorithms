package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int size = nums.length;
        int total = 1 << size; // 2^size
        for (int i = 0; i < total; i++) {
            int[] arr = new int[2];
            int bitCount = Integer.bitCount(i);
            if (bitCount == 2) {
                int p = 0;
                for (int j = 0; j < size; j++) {
                    if ((i & (1 << j)) != 0) {
                        arr[p++] = nums[j];
                    }
                }
                sum += hammingDistance(arr[0], arr[1]);
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(6, totalHammingDistance(new int[]{2, 4, 14}));
        assertEquals(4, totalHammingDistance(new int[]{4, 4, 14}));
    }

}
