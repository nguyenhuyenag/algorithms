package leetcode.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 * n -> binary -> reverse bit -> n'
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder builder = new StringBuilder(binaryString);
        for (int i = 0; i < builder.length(); i++) {
            builder.setCharAt(i, builder.charAt(i) == 0 ? '1' : '0');
        }
        return Integer.valueOf(builder.toString(), 2);
    }

    @Test
    public void test() {
        // Assertions.assertEquals();
    }
}
