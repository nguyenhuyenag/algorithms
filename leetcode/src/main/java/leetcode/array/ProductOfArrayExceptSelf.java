package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * Cho mảng số nguyên A[n]. Tạo mảng mới với giá trị tại vị trí i bằng tích của các vị trị khác i.
 *
 * Yêu cầu: Hàm chạy với với thời gian O(n) và không dùng phép chia.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf_2(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        int[] prefix = new int[n]; //
        int[] suffix = new int[n];

        // Mỗi phần tử sẽ bằng tích của các phần tử bên trái
        int product = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = product;
            product *= nums[i];
        }

        // Mỗi phần tử sẽ bằng tích của các phần tử bên phải
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = product;
            product *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = Arrays.stream(nums).reduce(1, (a, b) -> a * b);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prod != 0 ? prod / nums[i] : (nums[i] != 0 ? nums[i] : 0);
        }
        return result;
    }

    @Test
    public void test() {
        // assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

}
