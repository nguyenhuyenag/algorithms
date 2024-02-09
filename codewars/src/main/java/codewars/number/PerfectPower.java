package codewars.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/54d4c8b08776e4ad92000835/
 *
 * Cho số nguyên n. Tìm a, n sao cho a^b = n
 */
public class PerfectPower {

    public int[] isPerfectPower(int n) {
        for (int a = 2; a * a <= n; a++) {
            int b = 2;
            while (Math.pow(a, b) <= n) {
                if (Math.pow(a, b) == n) {
                    return new int[]{a, b};
                }
                b++;
            }
        }
        return null;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2, 2}, isPerfectPower(4));
        assertArrayEquals(new int[]{2, 3}, isPerfectPower(8));
    }


}
