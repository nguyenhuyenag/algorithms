package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSaleStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    @Test
    public void test() {
        assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
