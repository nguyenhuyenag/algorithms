package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Tìm 2 số i <= j sao cho arr[j] - arr[i] lớn nhất. Trả về giá trị lớn nhất đó
 */
public class BestTimeToBuyAndSaleStock {

//    public int maxProfit(int[] arr) {
//        int maxDiff = 0;
//        int minElement = arr[0];
//        for (int x : arr) {
//            // Tính toán diff của phần tử hiện tại và phần tử nhỏ nhất
//            // int currentDiff = x - minElement;
//            // Tìm maxDiff mới nếu có
//            maxDiff = Math.max(maxDiff, x - minElement);
//            // Tìm phần tử nhỏ nhất nếu có
//            minElement = Math.min(minElement, x);
//        }
//        return maxDiff;
//    }

    public int maxProfit(int[] nums) {
        int minValue = nums[0];
        int maxDiff = -1;
        for (int num : nums) {
            maxDiff = Math.max(maxDiff, num - minValue);
            minValue = Math.min(minValue, num);
        }
        return maxDiff;
    }

    @Test
    public void test() {
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(3, maxProfit(new int[]{2, 1, 4}));
    }

}
