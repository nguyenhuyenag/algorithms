package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/*
 	https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/

 	F(-n) = (-1)^(n + 1) * F(n)
 */
public class TheMillionthFibonacci {

    public static BigInteger helper(int n) {
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE, c = BigInteger.ZERO;
        if (n < 2) {
            return new BigInteger(String.valueOf(n));
        }
        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

    public static BigInteger fib(BigInteger num) {
        int n = num.intValue();
        if (n <= 0) {
            if (n % 2 == 0) {
                return new BigInteger("-1").multiply(helper(n));
            }
        }
        return helper(n);
    }

    @Test
    public void test() {
        // Assertions.assertEquals(1,1);
        BigInteger num = new BigInteger("-2");
        // System.out.println(num.intValue() % 2);
        System.out.println(fib(num));
    }

}
