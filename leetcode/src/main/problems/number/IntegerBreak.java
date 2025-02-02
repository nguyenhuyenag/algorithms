package number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/integer-break/
 * <p>
 * Tìm số lớn nhất bằng tích những số nguyên dương, có tổng là n.
 */
public class IntegerBreak {

    public int integerBreak_0(int n) {
        if (n < 4) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        // System.out.println("result = " + result);
        return result;
    }

    public int integerBreak_OK(int n) {
        // @formatter:off
        if (n < 4) {
            return n - 1; // Trường hợp đặc biệt khi n là 2 hoặc 3
        }
        int k = n / 3;  // Đếm số 3
        int r = n % 3;  // Còn dư
        if (r == 1) {
            // Nếu còn dư 1 thì lấy một số 3 để tạo thành 4 = 2 + 2 -> tích lớn hơn
            k--;
            r += 3;
        }
        // Số lớn nhất sẽ được tạo ra bằng cách sử dụng k số 3 và r số 1 hoặc 2
        System.out.println("3^" + k + " * 2^" + r / 2);
        int maxProduct = (int) Math.pow(3, k) * (int) Math.pow(2, r / 2);
        // @formatter:on
        return maxProduct;
    }

    /*
        n = 3k + r
         + r = 0 => max = 3^k
         + r = 1 => max = 4 * 3^(k - 1)
         + r = 2 => max = 2 * 3^k
     */
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1; // If n is 1 or less, the maximum product is n itself
        }
        int k = n / 3; // Number of 3's
        int r = n % 3; // Remainder
        // Calculate the maximum product based on the remainder
        return switch (r) {
            case 0 -> (int) Math.pow(3, k);
            case 1 -> (int) Math.pow(3, k - 1) * 4;
            case 2 -> (int) Math.pow(3, k) * 2;
            default -> 0;
        };
    }

    @Test
    public void test() {
        assertEquals(1, integerBreak(2));
        assertEquals(36, integerBreak(10));
        assertEquals(integerBreak_OK(16), integerBreak(16));
        assertEquals(integerBreak_OK(41), integerBreak(41));
    }

}
