package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/base-7/
 *
 * Biểu diễn số n dưới dạng cơ số 7
 */
public class Base7 {

    public String convertToBase7_OK(int n) {
        return Integer.toString(n, 7);
    }

    public String convertToBase7(int n) {
        if (n == 0) return "0";
        StringBuilder result = new StringBuilder();
        int m = Math.abs(n);
        while (m > 0) {
            result.append(m % 7);
            m /= 7;
        }
        return (n < 0 ? "-" : "") + result.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals("202", convertToBase7(100));
        assertEquals("0", convertToBase7(0));
        assertEquals("-10", convertToBase7(-7));
    }
}
