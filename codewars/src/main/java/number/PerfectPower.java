package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/54d4c8b08776e4ad92000835/
 *
 * Kiểm tra số n có phải là lũy thừa của một số khác hay không (tìm a, b để a^b = n)
 */
public class PerfectPower {

    public static int[] isPerfectPower_OK(int n) {
        for (int i = 2; i * i <= n; i++) {
            int num = n; // Reset num
            int count = 0;
            while (num % i == 0) {
                count++;
                num /= i;
            }
            if (num == 1) {
                return new int[]{i, count};
            }
        }
        return null;
    }

    public static int[] isPerfectPower(int n) {
        for (int a = 2; a * a <= n; a++) {
            for (int b = 2; Math.pow(a, b) <= n; b++) {
                if (Math.pow(a, b) == n) {
                    return new int[]{a, b};
                }
            }
        }
        return null;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2, 2}, isPerfectPower(4));
        assertArrayEquals(new int[]{2, 3}, isPerfectPower(8));
        assertArrayEquals(new int[]{3, 4}, isPerfectPower(81));
    }

}
