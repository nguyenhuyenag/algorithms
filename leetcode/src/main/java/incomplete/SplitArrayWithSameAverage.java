package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/split-array-with-same-average/

    Cho mảng số nguyên. Kiểm tra xem có thể chia mảng thành 2 mảng con sao cho trung bình cộng
    của chúng bằng nhau.
 */
public class SplitArrayWithSameAverage {

    // TLE
    public boolean splitArraySameAverage(int[] nums) {
        int size = nums.length;
        int allMasks = 1 << size;
        int sum = Arrays.stream(nums).sum();

        // Bỏ qua bit 0 và allMasks - 1 để tránh mảng rỗng
        for (int bit = 1; bit < allMasks - 1; bit++) {
            int sum1 = 0; // Tổng phần tử mảng con
            int size1 = 0; // Số phần tử mảng con
            for (int j = 0; j < size; j++) {
                if ((bit & (1 << j)) != 0) {
                    sum1 += nums[j];
                    size1++;
                }
            }

            if (size1 > 0 && size != size1 && sum1 * (size - size1) == (sum - sum1) * size1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true, splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(false, splitArraySameAverage(new int[]{1, 3}));
        assertEquals(false, splitArraySameAverage(new int[]{6, 8, 18, 3, 1}));
    }
}
