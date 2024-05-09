package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a54e796b3bfa8932c0000ed/
 *
 * Jumping number là số mà khoảng cách giữa 2 chữ số liền kề đều là 1.
 */
public class JumpingNumber {

    public static boolean jumpingNumber(int number) {
        int[] digits = Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (Math.abs(digits[i] - digits[i + 1]) != 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Single_Digit_Number() {
        assertEquals(true, jumpingNumber(9));
        assertEquals(true, jumpingNumber(1));
        assertEquals(true, jumpingNumber(7));
    }

    @Test
    public void Two_Digit_Number() {
        assertEquals(true, jumpingNumber(23));
        assertEquals(true, jumpingNumber(32));
        assertEquals(false, jumpingNumber(79));
        assertEquals(true, jumpingNumber(98));
    }

    @Test
    public void Larger_Numbers() {
        assertEquals(true, jumpingNumber(8987));
        assertEquals(true, jumpingNumber(4343456));
        assertEquals(true, jumpingNumber(98789876));
    }

}
