package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class WarMain {

    public static String binaryAddition(int a, int b) {
        int sum = a + b;
        StringBuilder binary = new StringBuilder();
        if (sum == 0) {
            return "0";
        }
        while (sum > 0) {
            int remainder = sum % 2;
            binary.insert(0, remainder);
            sum /= 2;
        }
        return binary.toString();
    }

    @Test
    public void doTest() {
        assertEquals("10", binaryAddition(1, 1));
        assertEquals("1110", binaryAddition(5, 9));
        assertEquals("111111", binaryAddition(51, 12));
    }

}
