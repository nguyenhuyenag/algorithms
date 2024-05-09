package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 * Reverse bits of a given '32 bits' unsigned integer.
 *
 * n -> binary -> reverse binary -> n'
 */
public class ReverseBits {

    // You need treat n as an unsigned value
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        // Thêm số '0' đầu chuỗi để thành dãy 32 bit
        // "0".repeat(32 - binary.length()) + binary;
        StringBuilder builder = new StringBuilder(binary);
        builder.insert(0, "0".repeat(32 - binary.length()));
        return Integer.parseUnsignedInt(builder.reverse().toString(), 2);
    }

    @Test
    public void test() {
        assertEquals(805306368, reverseBits(12));
        assertEquals(2013265920, reverseBits(30));
    }

}
