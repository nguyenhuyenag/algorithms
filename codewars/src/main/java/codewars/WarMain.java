package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class WarMain {

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
