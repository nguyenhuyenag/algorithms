package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/permutation-sequence/
 */
public class MainTest {

    private static int[] fact = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public String getPermutation(int n, int k) {
        k--;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int fg = fact(list.size() - 1);
            int index = k / fg;
            result.append(list.get(index));
            list.remove(index);
            k = k % fg;
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("213", getPermutation(3, 3));
    }

}
