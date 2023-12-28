package codewars.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a3e1319b6486ac96f000049/
 */
public class SimpleConsecutivePairs {

    public static int solve(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (Math.abs(arr[i] - arr[i + 1]) == 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void doTest() {
        assertEquals(3, solve(new int[]{1, 2, 5, 8, -4, -3, 7, 6, 5}));
        assertEquals(4, solve(new int[]{-55, -56, -7, -6, 56, 55, 63, 62}));
        assertEquals(0, solve(new int[]{81, 44, 80, 26, 12, 27, -34, 37, -35}));
        assertEquals(2, solve(new int[]{21, 20, 22, 40, 39, -56, 30, -55, 95, 94}));
    }

}
