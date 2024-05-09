package incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * https://www.codewars.com/kata/5819f1c3c6ab1b2b28000624/
 *
 * P(0) = P(1) = P(2) = 1, P(n) = P(n-2) + P(n-3)
 */
public class BigPadovanNumber {

//    public static BigInteger Get_0(long power) {
//        Map<Long, BigInteger> mapNums = new HashMap<>();
//        mapNums.put(0L, BigInteger.ONE);
//        mapNums.put(1L, BigInteger.ONE);
//        mapNums.put(2L, BigInteger.ONE);
//        if (!mapNums.containsKey(power)) {
//            for (long i = 3; i <= power; i++) {
//                mapNums.put(i, mapNums.get(i - 2).add(mapNums.get(i - 3)));
//            }
//        }
//        return mapNums.get(power);
//    }
//
//    public static long Get(long n) {
//        if (n == 0 || n == 1 || n == 2) {
//            return 1; // Base cases for P(0), P(1), and P(2)
//        }
//        long p0 = 1, p1 = 1, p2 = 1, nextTerm = 0;
//        for (int i = 3; i <= n; i++) {
//            nextTerm = p0 + p1;
//            // Update values for the next iteration
//            p0 = p1;
//            p1 = p2;
//            p2 = nextTerm;
//        }
//        return nextTerm;
//    }

    public static BigInteger Get(long n) {
        if (n == 0 || n == 1 || n == 2) {
            return BigInteger.ONE; // Base cases for P(0), P(1), and P(2)
        }
        BigInteger p0 = BigInteger.ONE;
        BigInteger p1 = BigInteger.ONE;
        BigInteger p2 = BigInteger.ONE;
        BigInteger nextTerm = BigInteger.ZERO;
        for (int i = 3; i <= n; i++) {
            nextTerm = p0.add(p1); //  p0 + p1;
            // Update values for the next iteration
            p0 = p1;
            p1 = p2;
            p2 = nextTerm;
        }
        return nextTerm;
    }

    @Test
    public void ValueTest1() {
        assertEquals(BigInteger.ONE, Get(1));
        assertEquals(BigInteger.ONE, Get(2));
        assertEquals(new BigInteger("2"), Get(3));
        assertEquals(new BigInteger("2"), Get(4));
        assertEquals(new BigInteger("1177482265857"), Get(100));
    }

}
