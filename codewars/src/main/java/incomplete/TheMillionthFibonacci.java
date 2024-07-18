package incomplete;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
 	https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/

 	F(-n) = (-1)^(n + 1) * F(n)
 */
public class TheMillionthFibonacci {

    public static BigInteger fib(BigInteger n) {
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE, c = BigInteger.ZERO;
        if (n.intValue() < 2) {
            return new BigInteger(String.valueOf(n));
        }
        for (int i = 2; i <= n.intValue(); i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

}
