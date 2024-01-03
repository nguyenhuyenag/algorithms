package codewars.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a54e796b3bfa8932c0000ed/
 *
 * Jumping number là số mà khoảng cách giữa 2 chữ số liền kề đều là 1.
 */
public class JumpingNumber {

    public static String jumpingNumber(int number) {
        int[] digits = Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .toArray();

        for (int i = 0; i < digits.length - 1; i++) {
            if (Math.abs(digits[i] - digits[i + 1]) != 1) {
                return "Not!!";
            }
        }

        return "Jumping!!";
    }

    @Test
    public void Single_Digit_Number() {
        assertEquals("Jumping!!", jumpingNumber(9));
        assertEquals("Jumping!!", jumpingNumber(1));
        assertEquals("Jumping!!", jumpingNumber(7));
    }

    @Test
    public void Two_Digit_Number() {
        assertEquals("Jumping!!", jumpingNumber(23));
        assertEquals("Jumping!!", jumpingNumber(32));
        assertEquals("Not!!", jumpingNumber(79));
        assertEquals("Jumping!!", jumpingNumber(98));
    }

    @Test
    public void Larger_Numbers() {
        assertEquals("Jumping!!", jumpingNumber(8987));
        assertEquals("Jumping!!", jumpingNumber(4343456));
        assertEquals("Jumping!!", jumpingNumber(98789876));
    }

}
