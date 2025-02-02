package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Mảng đánh dấu
 *
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {

    public int findDuplicate0(int[] nums) {
        int x = 0;
        for (int a : nums) {
            x ^= a;
        }
        return x;
    }

    public int findDuplicate(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] mark = new int[max + 1];
        for (int x : nums) {
            mark[x]++;
        }
        // System.out.println("mark = " + Arrays.toString(mark));
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] >= 2) {
                return i;
            }
        }
        return 0;
    }



    @Test
    public void doTest() {
        assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
        assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
        assertEquals(2, findDuplicate(new int[]{2, 2, 2, 2, 2}));
    }

}
