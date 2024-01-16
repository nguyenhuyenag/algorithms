package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class MainWar {

    public static boolean isNarcissistic(int number) {
        int sum = 0;
        String numStr = Integer.toString(number);
        int p = numStr.length();
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            sum += Math.pow(digit, p);
        }
        return sum == number;
    }

    @Test
    void exampleTests() {
        assertEquals(true, isNarcissistic(153));
        assertEquals(true, isNarcissistic(1634));
        assertEquals(false, isNarcissistic(112));
    }

    @Test
    public void test() {

    }

}
