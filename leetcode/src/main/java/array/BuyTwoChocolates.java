package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/buy-two-chocolates/
 *
 * Tìm 2 số a, b trong mảng sao cho a + b <= x. Trả về giá trị x - a - b
 */
public class BuyTwoChocolates {

    public int buyChoco0(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                // Tìm thấy cặp số có tổng không vượt quá target
                return target - sum;
            } else {
                // Giảm tổng lên bằng cách di chuyển chỉ số right sang trái
                r--;
            }
        }
        // Trường hợp không tìm thấy cặp số nào
        return target;
    }

    public int buyChoco1(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] <= money ? money - (prices[0] + prices[1]) : money;
    }

    public int buyChoco(int[] prices, int money) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int p : prices) {
            queue.add(p);
        }
        int total = queue.poll() + queue.poll();
        return total <= money ? money - total : money;
    }

    @org.junit.jupiter.api.Test
    public void doTest() {
        assertEquals(0, buyChoco(new int[]{1, 2, 2}, 3));
        assertEquals(3, buyChoco(new int[]{3, 2, 3}, 3));
        assertEquals(3, buyChoco(new int[]{98, 54, 6, 34, 66, 63, 52, 39}, 62)); // 3
    }

}
