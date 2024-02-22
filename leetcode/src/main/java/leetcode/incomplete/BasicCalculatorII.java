package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        return 1;
    }

    @Test
    public void test() {
        assertEquals(6, calculate("1+2+3"));
        assertEquals(1, calculate("3/2"));
    }
}
