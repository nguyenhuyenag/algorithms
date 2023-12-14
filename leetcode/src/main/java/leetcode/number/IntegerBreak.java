package leetcode.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/integer-break/
 * <p>
 * Tìm số lớn nhất bằng tích những số nguyên dương, có tổng là n
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        ans *= n;
        return ans;
    }

    @Test
    public void test() {
        assertEquals(36, integerBreak(10));
        // assertEquals(2, integerBreak(10));
    }

}
