package array;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Một mảng số nguyên chỉ chứa các số từ 1 -> n, nhưng do bị lỗi nên kết quả không đúng
 * và có 1 số bị lặp và 1 số thiếu.
 *
 * Tìm số trùng lặp và số bị thiếu đó
 *
 *      [1,2,2,4]       ->      [2,3]
 */
public class SetMisMatch {

    public int[] findErrorNums(int[] nums) {
        int missing = -1, duplicate = -1;
        int[] mark = new int[nums.length + 1];
        for (int num : nums) {
            mark[num]++;
        }
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] == 0) {
                missing = i;
            } else if (mark[i] == 2) {
                duplicate = i;
            }
        }
        return new int[]{duplicate, missing};
    }

    public int[] findErrorNums0(int[] nums) {
        int sum = 0;
        int duplicate = -1;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                duplicate = nums[i];
            }
            sum += nums[i];
        }
        int missing = (n * (n + 1)) / 2 + duplicate - sum;
        return new int[]{duplicate, missing};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2, 3}, findErrorNums(new int[]{1, 2, 2, 4}));
        assertArrayEquals(new int[]{1, 2}, findErrorNums(new int[]{1, 1}));
        assertArrayEquals(new int[]{2, 1}, findErrorNums(new int[]{2, 2}));
        assertArrayEquals(new int[]{2, 1}, findErrorNums(new int[]{2,3,2}));
    }

}
