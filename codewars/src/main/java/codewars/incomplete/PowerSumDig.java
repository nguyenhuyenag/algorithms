package codewars.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://www.codewars.com/kata/55f4e56315a375c1ed000159/
 *
 * Số đặc biệt là số thỏa mãn: (tổng các chữ số) ^ (số lượng các chữ số) = chính nó
 *
 * Ví dụ:
 *      81	 => 8 + 1          = 9  and 9^2 = 81
 *      512  => 5 + 1 + 2      = 8  and 8^3 = 512
 *      2401 => 2 + 4 + 0 + 1  = 7  and 7^4 = 2401
 */
public class PowerSumDig {

    public static boolean hasSpecialProperty(long n) {
        long originalN = n;
        int sum = 0, count = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
            count++;
        }

        long powerResult = 1;
        for (int i = 0; i < count; i++) {
            powerResult *= sum;
        }

        return originalN == powerResult;
    }

    public static long powerSumDigTerm(int n) {
        int count = 0;
        int num = 10; // Starting from 10 because we're not considering numbers of one digit
        while (count < n) {
            if (hasSpecialProperty(num)) {
                count++;
            }
            num++;
        }
        return num - 1;
    }

    @Test
    public void test() {
        // assertEquals(81, powerSumDigTerm(1));
        // assertEquals(512, powerSumDigTerm(2));
        // assertEquals(2401, powerSumDigTerm(3));
        // assertEquals(4913, powerSumDigTerm(4));
    }

}
