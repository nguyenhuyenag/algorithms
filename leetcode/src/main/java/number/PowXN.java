package number;

import org.junit.jupiter.api.Test;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement hàm pow(a, n)
 *
 * Lũy thừa nhị phân sử dụng đệ quy O(logn)
 */
public class PowXN {

    public double myPow_1(double a, long n) {
        if (n == 0) return 1;
        // n < 0
        if (n < 0) {
            return 1 / myPow_1(a, -n);
        }
        // n > 0
        if (n % 2 == 0) {
            double x = myPow_1(a, n / 2);
            return x * x;
        }
        return a * myPow_1(a, n - 1);
    }

    public static double myPow_2(double a, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            a = 1 / a;
        }
        return n % 2 == 0 ? myPow_2(a * a, n / 2) : a * myPow_2(a * a, n / 2);
    }

    public double myPow(double a, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            a = 1 / a;
        }
        if (n % 2 == 0) {
            double x = myPow(a, n / 2);
            return x * x;
        }
        double x = myPow(a, (n - 1) / 2);
        return a * x * x;
    }

    @Test
    public void test() {
        assertEquals(pow(2, 10), myPow(2, 10));
        assertEquals(pow(2, -2), myPow(2, -2));
        assertEquals(pow(2.1, 3), myPow(2.1, 3));

        // Time Limit Exceeded ↓
        assertEquals(pow(1.0, 2147483647), myPow_1(1.00000, 2147483647));
    }

}
