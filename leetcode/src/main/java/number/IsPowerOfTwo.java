package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Kiểm tra một số n có phải là luy thừa của 2 không?
 *
 * Xem thêm: leetcode > PowerOfFour.java
 */
public class IsPowerOfTwo {

    // Một số có dạng 2^n khi biểu diễn nhị phân sẽ có đúng một bit `1`
    public boolean isPowerOfTwo_OK(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    @Test
    public void test() {
        assertEquals(true, isPowerOfTwo(2));
        assertEquals(true, isPowerOfTwo(16));
        assertEquals(false, isPowerOfTwo(9));
    }

}
