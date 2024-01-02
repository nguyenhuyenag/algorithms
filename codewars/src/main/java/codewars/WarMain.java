package codewars;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class WarMain {

    public static boolean isPrime(int n) {
        for (int i = 0; i < Math.sqrt(n); i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(false, isPrime(0));
        assertEquals(false, isPrime(1));
        assertEquals(true, isPrime(2));
        assertEquals(true, isPrime(73));
        assertEquals(false, isPrime(75));
        assertEquals(false, isPrime(-1));
    }

}
