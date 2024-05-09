package number;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Chủ đề: Quy hoạch động, dynamic programing
 *
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class UglyNumberII {

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    /**
     * Vì số xấu chỉ có thể chia hết cho 2, 3, 5 nên dãy số xấu có thể được tạo thành từ 3 dãy con
     *  (1): 1×2, 2×2, 3×2, 4×2, 5×2,...
     *  (2): 1×3, 2×3, 3×3, 4×3, 5×3,...
     *  (3): 1×5, 2×5, 3×5, 4×5, 5×5,...
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;  // Số xấu đầu tiên
        int i2 = 0; // 1×2, 2×2, 3×2, 4×2, 5×2,... Tạo số xấu của 2
        int i3 = 0; // 1×3, 2×3, 3×3, 4×3, 5×3,... Tạo số xấu của 3
        int i5 = 0; // 1×5, 2×5, 3×5, 4×5, 5×5,... Tạo số xấu của 5
        for (int i = 1; i < n; i++) {
            int nextNumber = min(2 * dp[i2], 3 * dp[i3], 5 * dp[i5]);
            dp[i] = nextNumber;
            if (nextNumber == 2 * dp[i2]) i2++;
            if (nextNumber == 3 * dp[i3]) i3++;
            if (nextNumber == 5 * dp[i5]) i5++;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n - 1]; // Do mảng đếm từ 0-index
    }

    @Test
    public void test() {
        assertEquals(12, nthUglyNumber(10));
        assertEquals(1, nthUglyNumber(1));
        assertEquals(4, nthUglyNumber(4));
        assertEquals(8, nthUglyNumber(7));
        assertEquals(15, nthUglyNumber(11));
    }

}
