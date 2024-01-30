package codewars;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/54b724efac3d5402db00065e/
 */
public class MainWar {

    public static long fibonacci(long n) {
        Map<Integer, Long> fibo = new HashMap<>();
        fibo.put(0, 0L);
        fibo.put(1, 1L);
        int i = 2;
        long sum = 0;
        while (true) {
            long currentFibo = fibo.get(i - 1) + fibo.get(i - 2);
            if (currentFibo > n) break;
            fibo.put(i, currentFibo);
            if (currentFibo % 2 == 0 && currentFibo < n) {
                sum += currentFibo;
            }
            i++;
        }
        // System.out.println("fibo = " + fibo);
        return sum;
    }

    public static long fibonacci_0(long limit) {
        long a = 1, b = 1, s = 0;
        while (a < limit) {
            if (a % 2 == 0) s += a;
            long temp = a;
            a = b;
            b += temp;
        }
        return s;
    }

    @Test
    public void test() {
        assertEquals(1485607536, fibonacci(2147483647));
        assertEquals(350704366, fibonacci(1000000000));
        assertEquals(82790070, fibonacci(100000000));
        assertEquals(1089154, fibonacci(1000000));
        assertEquals(798, fibonacci(1000));
        assertEquals(44, fibonacci(100));
        assertEquals(2, fibonacci(5));
        assertEquals(2, fibonacci(8));
        assertEquals(10, fibonacci(10));
        assertEquals(0, fibonacci(1));
    }

}
