package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Chủ đề: Two pointer, in-place algorithm
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Dời các phần tử bằng 0 về cuối mảng, không dùng mảng phụ
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int p = 0;

        // Dời các phần tử != 0 lên đầu mảng
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }

        // Đánh dấu các phần tử còn lại là 0
        for (int i = p; i < len; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test1() {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0, 0}, nums);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

}
