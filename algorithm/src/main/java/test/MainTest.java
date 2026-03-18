package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/permutation-sequence/
 */
public class MainTest {

//    private static int[] fact = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//
//    public static int fact(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return n * fact(n - 1);
//    }
//
//    public String getPermutation(int n, int k) {
//        k--;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            int fg = fact(list.size() - 1);
//            int index = k / fg;
//            result.append(list.get(index));
//            list.remove(index);
//            k = k % fg;
//        }
//        return result.toString();
//    }
//
//    @Test
//    public void test() {
//        assertEquals("213", getPermutation(3, 3));
//    }

    public int fib_OK(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibMemory(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int f = a + b;
            a = b;
            b = f;
        }
        return b; // Lúc này là f
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    @Test
    public void test() {
        Assertions.assertEquals(1, fib(2));
        Assertions.assertEquals(2, fib(3));
        Assertions.assertEquals(3, fib(4));
    }

}
