package leetcode.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement hàm: Math.pow(x, n)
 */
public class PowXN {

    public double myPow(double x, long n) {
        if (n == 0) return 1;
        // n < 0
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        // n > 0
        if (n % 2 == 0) {
            double t = myPow(x, n / 2);
            return t * t;
        }
        return x * myPow(x, n - 1);
    }

    @Test
    public void test() {
        assertEquals(pow(2, 10), myPow(2, 10));
        assertEquals(pow(2, -2), myPow(2, -2));
        assertEquals(pow(2.1, 3), myPow(2.1, 3));

        // Time Limit Exceeded ↓
        assertEquals(pow(1.0, 2147483647), myPow(1.00000, 2147483647));
    }

//    	public static double myPow(double x, long n) {
//		if (n == 0) {
//			return 1;
//		}
//		if (n < 0) {
//			n = -n;
//			x = 1 / x;
//		}
//		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
//	}

}
