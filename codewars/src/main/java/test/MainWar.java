package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/51e056fe544cf36c410000fb/
 */
public class MainWar {

    public static boolean isPowerOfTwo1(long n) {
        while (n != 0 && n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static boolean isPowerOfTwo(long n) {
        return Long.bitCount(n) == 1;
    }

    @Test
    void testPowerOfTwo() {
        assertEquals(true, isPowerOfTwo(2));
        assertEquals(true, isPowerOfTwo(4096));
    }

    @Test
    void testNotPowersOfTwo() {
        assertEquals(false, isPowerOfTwo(333));
        assertEquals(false, isPowerOfTwo(0));
    }

}
