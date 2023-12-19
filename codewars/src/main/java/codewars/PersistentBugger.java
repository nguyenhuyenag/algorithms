package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/
 *
 * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
 *
 * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
 *
 * 4 --> 0 (because 4 is already a one-digit number)
 */
public class PersistentBugger {

    int[] dem = {0}; // Mảng để lưu giá trị đếm

    public int multiDigits(long n) {
        int mul = 1;
        while (n > 0) {
            int l = (int) (n % 10);
            mul *= l;
            n /= 10;
        }
        if (mul > 9) {
            dem[0]++;
            return multiDigits(mul);
        }
        return mul;
    }

    public int persistence(long n) {
        multiDigits(n);
        return dem[0] + 1;
    }

    @Test
    public void doTest() {
        // assertEquals(3, persistence(39));
        // assertEquals(4, persistence(999));
        assertEquals(0, persistence(4));
    }

}
