package leetcode.number;

import org.junit.jupiter.api.Test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement hàm: pow(x, n)
 */
public class PowXN {

    public double myPow_OK(double x, long n) {
        if (n == 0) return 1;
        // n < 0
        if (n < 0) {
            return 1 / myPow_OK(x, -n);
        }
        // n > 0
        if (n % 2 == 0) {
            double t = myPow_OK(x, n / 2);
            return t * t;
        }
        return x * myPow_OK(x, n - 1);
    }

    public double myPow(double a, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            a = 1 / a;
        }
        if (n % 2 == 0) {
            double temp = myPow(a, n / 2);
            return temp * temp;
        }
        double temp = myPow(a, (n - 1) / 2);
        return a * temp * temp;
    }

    @Test
    public void test() {
        assertEquals(pow(2, 10), myPow(2, 10));
        assertEquals(pow(2, -2), myPow(2, -2));
        assertEquals(pow(2.1, 3), myPow(2.1, 3));

        // Time Limit Exceeded ↓
        assertEquals(pow(1.0, 2147483647), myPow_OK(1.00000, 2147483647));
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
