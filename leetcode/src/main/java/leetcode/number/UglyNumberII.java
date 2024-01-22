package leetcode.number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class UglyNumberII {

//    public boolean isUgly(int n) {
//        if (n == 0) return false;
//        int[] divisors = {2, 3, 5};
//        for (int d : divisors) {
//            while (n % d == 0) {
//                n /= d;
//            }
//        }
//        return n == 1;
//    }

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            uglyNumbers[i] = min;

            if (factor2 == min) {
                factor2 = 2 * uglyNumbers[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * uglyNumbers[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * uglyNumbers[++index5];
            }
            System.out.println("arr = " + Arrays.toString(uglyNumbers));
        }

        return uglyNumbers[n - 1];
    }

    @Test
    public void test() {
        assertEquals(12, nthUglyNumber(10));
        assertEquals(1, nthUglyNumber(1));
    }

}
