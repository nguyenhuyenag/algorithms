package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5287e858c6b5a9678200083c/
 *
 * Kiểm tra số Narcissistic (số Armstrong)
 *
 *      153  = 1^3 + 5^3 + 3^3
 *      1634 = 1^4 + 6^4 + 3^4 + 4^4
 */
public class DoesMyNumberLookBigInThis {

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
