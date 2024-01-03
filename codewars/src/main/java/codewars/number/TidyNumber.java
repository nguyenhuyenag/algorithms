package codewars.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a87449ab1710171300000fd/
 *
 * Kiểm tra số có chữ số tăng dần
 */
public class TidyNumber {

    public static boolean tidyNumber0(int n) {
        String strNum = String.valueOf(n);
        final String[] digits = strNum.split("");
        java.util.Arrays.sort(digits);
        return String.join("", digits).equals(strNum);
    }

    public static boolean isSortedArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean tidyNumber(int number) {
        int[] digits = Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        return isSortedArray(digits);
    }

    @Test
    public void Check_Small_Values() {
        assertEquals(true, tidyNumber(12));
        assertEquals(false, tidyNumber(32));
        assertEquals(true, tidyNumber(39));
    }

    @Test
    public void Check_Larger_Values() {
        assertEquals(false, tidyNumber(1024));
        assertEquals(false, tidyNumber(12576));
        assertEquals(true, tidyNumber(13579));
        assertEquals(true, tidyNumber(2335));
    }

}
