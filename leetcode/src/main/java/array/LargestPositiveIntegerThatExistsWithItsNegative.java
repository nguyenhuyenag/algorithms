package array;


import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 *
 * Cho mảng gồm các số nguyên khác không. Tìm số k lớn nhất sao cho tồn tại -k trong mảng.
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {

    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> seen = new TreeSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        for (int num : nums) {
            // Kiểm tra số thứ 2 có trong mảng không (seen chưa các phần tử của mảng)
            if (num > 0 && seen.contains(-num)) {
                max = Math.max(max, num);
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(3, findMaxK(new int[]{-1, 2, -3, 3}));
        assertEquals(7, findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        assertEquals(-1, findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
        assertEquals(37, findMaxK(new int[]{-37, 37, -9, 2, 47, 18, 13, -11, 9, -28}));
    }

    public int findMaxK_OK1(int[] nums) {
        int max = -1;
        Set<Integer> set = new TreeSet<>();
        // Số thứ nhất
        for (int n1 : nums) {
            // Số thứ 2
            int n2 = -n1;
            // Kiểm tra số thứ 2 có trong mảng không (set chưa các phần tử của mảng)
            if (set.contains(n2)) {
                max = Math.max(max, Math.max(n1, n2));
            }
            set.add(n1);
        }
        return max;
    }

    public int findMaxK_OK(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == 0) {
                    max = Math.max(max, Math.max(nums[i], nums[j]));
                }
            }
        }
        return max == 0 ? -1 : max;
    }

}
