package codewars.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/541c8630095125aba6000c00/
 *
 * Xem thêm: leetcode > AddDigits.java
 */
public class SumOfDigits {

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int digital_root_0(int n) {
        while (n >= 10) {
            n = sumOfDigits(n);
        }
        return n;
    }

    public static int digital_root(int n) {
        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(7, digital_root(16));
        assertEquals(6, digital_root(942));
        assertEquals(6, digital_root(132189));
        assertEquals(2, digital_root(493193));
    }

}
