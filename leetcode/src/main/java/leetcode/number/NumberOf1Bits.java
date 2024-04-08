package leetcode.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/number-of-1-bits/
    Đếm số bit 1 trong biểu diễn nhị phân của số n
 */
public class NumberOf1Bits {

    public int hammingWeight_OK(int n) {
        return Integer.bitCount(n);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

    @Test
    public void test() {
        // assertEquals(3, hammingWeight(11));
        // assertEquals(1, hammingWeight(128));
        assertEquals(30, hammingWeight(2147483645));
    }

}
