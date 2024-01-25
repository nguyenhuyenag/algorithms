package leetcode.dp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Giả sử đang ở bậc thang thứ i, số cách để đến bậc thang đó sẽ là tổng số cách để đến bậc
 * (i-1) và (i-2). Điều này dựa trên quy tắc rằng chỉ có thể di chuyển 1 hoặc 2 bước mỗi lần.
 *
 * Gọi F(i) là số cách để đến bậc thang thứ i. Ta có công thức quy hoạch động như sau:
 *
 *      F(1) = 1, F(2) = 2, F(i) = F(i−1) + F(i−2)
 */
public class ClimbingStairs {

    // TLE
    public int climbStairs0(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        dp.put(2, 2);
        for (int i = 3; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }

    @Test
    public void test() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }

}
