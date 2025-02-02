package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Tìm số nguyên duy nhất còn thiếu trong mảng thuộc [0, n]
 *
 *    [0, 1]       =>  2
 *    [3, 0, 1]    =>  2
 */
public class MissingNumber {

    public int missingNumber_OK(int[] nums) {
        boolean[] mark = new boolean[nums.length + 1];
        for (int v : nums) {
            mark[v] = true;
        }
        for (int i = 0; i < mark.length; i++) {
            if (!mark[i]) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    @Test
    public void doTest() {
        assertEquals(2, missingNumber(new int[]{0, 1}));
        assertEquals(2, missingNumber(new int[]{3, 0, 1}));
        assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
