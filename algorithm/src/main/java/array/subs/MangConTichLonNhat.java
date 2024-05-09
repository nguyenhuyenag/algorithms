package array.subs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Tìm mảng con có tích lớn nhất
 */
public class MangConTichLonNhat {

    // [2, 3, -2, 4] -> [2, 3] -> 6
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0];
        int cmin = nums[0]; // Tích nhỏ nhất tính đến thời điểm trước đó
        int cmax = nums[0]; // Tích lớn nhất tính đến thời điểm trước đó

        for (int i = 1; i < nums.length; i++) {
            // Nếu x < 0, đổi chỗ cmin và cmax để khi nhân với x sẽ tạo ra số lớn nhất
            int x = nums[i];
            if (x < 0) {
                int temp = cmax;
                cmax = cmin;
                cmin = temp;
            }

            // Cập nhật giá trị max và min bằng cách so sánh tích của chúng với phần tử hiện tại
            cmax = Math.max(cmax * x, x);
            cmin = Math.min(cmin * x, x);

            ans = Math.max(ans, cmax);
        }

        return ans;
    }

    @Test
    public void doTest() {
        assertEquals(6, maxProduct(new int[]{1, 2, 3, -2, 4}));
        assertEquals(0, maxProduct(new int[]{-2, 0, -1}));
    }

}
