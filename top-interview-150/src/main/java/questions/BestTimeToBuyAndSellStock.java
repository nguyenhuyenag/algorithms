package questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    ===========================================================
    // a given -> một cái gì đó nhất định
    => Bạn được cho một mảng prices với prices[i] là GIÁ của một cổ phiếu nhất định vào ngày thứ i.
    Bạn muốn tối đa hóa lợi nhuận bằng cách chọn một ngày để mua một cổ phiếu và chọn một ngày khác trong tương lai để bán cổ phiếu đó.
    Trả về lợi nhuận tối đa bạn có thể đạt được từ giao dịch này. Nếu bạn không thể đạt được lợi nhuận nào, trả về 0.
    ===========================================================
    Cho mảng prices, prices[i] là giá cổ phiếu ngày thứ i.
        1. Chọn 1 ngày mua và 1 ngày bán sau đó (bán phải ở tương lai).
        2. Tối đa hóa prices[sell] - prices[buy].
    Nếu không có lãi → trả về 0.

    Lưu ý: chỉ được giao dịch 1 lần (mua 1 lần, bán 1 lần), không phải mua bán nhiều lần.
 */
public class BestTimeToBuyAndSellStock {

    // Time Limit Exceeded 202 / 213 testcases passed
    public int maxProfitTLE(int[] prices) {
        int n = prices.length;
        int best = 0;

        // Duyệt mọi cặp (i, j) với i < j
        for (int i = 0; i < n; i++) {          // ngày mua
            for (int j = i + 1; j < n; j++) {  // ngày bán (phải sau ngày mua)
                int profit = prices[j] - prices[i];
                if (profit > best) {
                    best = profit;
                }
            }
        }
        return best;
    }

    public int maxProfitV1(int[] prices) {
        int maxProfit = 0;
        // Giả sử ngày đầu tiên là ngày có giá thấp nhất
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit; // TODO: Important
    }

    public int maxProfitV0(int[] prices) {
        int maxProfit = 0;
        // Giả sử ngày đầu tiên là ngày có giá thấp nhất
        int minPrice = prices[0];
        for (int price : prices) {
            // Tìm được ngày có giá thấp hơn -> Gán nó cho minPrice
            if (price < minPrice) {
                minPrice = price;
            } else { // Nếu không thì thử tính toán lợi nhuận khi bán và so sánh với maxProfit
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit; // TODO: Important
    }

    public int maxProfit(int[] prices) {
        return maxProfitTLE(prices);
        // return maxProfitV0(prices);
        // return maxProfitV1(prices);
    }


    @Test
    public void test1() {
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test2() {
        assertEquals(1, maxProfit(new int[]{1, 2}));
    }

}
