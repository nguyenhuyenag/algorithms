package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/reverse-bits/

    Reverse bits of a given '32 bits' unsigned integer.

        n1 -> binary -> reverse binary -> n2
 */
public class ReverseBits {

    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder builder = new StringBuilder();
        // Thêm số '0' đầu chuỗi để thành dãy 32 bit
        builder.append("0".repeat(32 - binary.length()));
        builder.append(binary);
        return Integer.parseUnsignedInt(builder.reverse().toString(), 2);
    }

    @Test
    public void test() {
        assertEquals(805306368, reverseBits(12));
        assertEquals(2013265920, reverseBits(30));
    }

}
