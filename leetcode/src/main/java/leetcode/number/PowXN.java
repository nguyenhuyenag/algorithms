package leetcode.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/powx-n
 *
 * Implement Math.pow(x, n)
 */
public class PowXN {

//	public static double myPow(double x, long n) {
//		if (n == 0) {
//			return 1;
//		}
//		if (n < 0) {
//			n = -n;
//			x = 1 / x;
//		}
//		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
//	}

//	public double myPow(double x, int n) {
//		return myPow(x, (int) (n + 0l));
//	}

//    public double myPow(double x, int n) {
//        double result = 1;
//        for (int i = 0; i < Math.abs(n); i++) {
//            result *= x;
//        }
//        return n > 0 ? result : 1 / result;
//    }

    // For n > 0
    public double myPow(double x, int n) {
        if (n % 2 == 0) {
            double t = myPow(x, n / 2);
            return t * t;
        }
        // return myPow(x * x, n - 1);
        return 1;
    }

    @Test
    public void test() {
        assertEquals(Math.pow(2, 10), myPow(2, 10));
        // assertEquals(Math.pow(2.1, 3), myPow(2.1, 3));
        // assertEquals(Math.pow(2, -2), myPow(2, -2));

        // Time Limit Exceeded ↓
        // assertEquals(Math.pow(1.00000, 2147483647), myPow(1.00000, 2147483647));
    }

}
