package leetcode.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/power-of-four/
 *
 * Kiểm tra số N có phải là lũy thừa của 4 hay không (4^x = N)
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n < 1) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    @Test
    public void test() {
        assertEquals(true, isPowerOfFour(16));
        assertEquals(true, isPowerOfFour(1));
    }

}
