package leetcode.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/integer-break/
 *
 * Tìm số lớn nhất bằng tích những số nguyên dương, có tổng là n
 */
public class IntegerBreak {

    public int integerBreak(int n) {
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

    public int integerBreak0(int n) {
        if (n < 4) {
            return n - 1; // Trường hợp đặc biệt khi n là 2 hoặc 3
        }
        int countOf3 = n / 3;   // Đếm số 3
        int remainder = n % 3;  // Còn dư
        if (remainder == 1) {
            // Nếu còn dư 1 thì lấy một số 3 để tạo thành 4 = 2 + 2 -> tích lớn hơn
            countOf3--;
            remainder += 3;
        }
        // Số lớn nhất sẽ được tạo ra bằng cách sử dụng countOf3 số 3 và remainder số 1 hoặc 2
        System.out.println("3^" + countOf3 + " * 2^" + remainder / 2);
        int maxProduct = (int) Math.pow(3, countOf3) * (int) Math.pow(2, remainder / 2);
        return maxProduct;
    }

    @Test
    public void test() {
        assertEquals(1, integerBreak0(2));
        assertEquals(36, integerBreak0(10));
        assertEquals(324, integerBreak0(16));
        assertEquals(integerBreak(41), integerBreak0(41));
    }

}
