package codewars.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class TribonacciSequence {

    public static double[] tribonacci(double[] arr, int n) {
        double[] res = new double[n];
        if (n == 0) {
            return res;
        }
        // Copy the initial signature to result
        System.arraycopy(arr, 0, res, 0, Math.min(n, 3));
        if (n <= 3) {
            return res;
        }
        for (int i = 3; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];
        }
        return res;
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, tribonacci(new double[]{1, 1, 1}, 10));
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, tribonacci(new double[]{0, 0, 1}, 10));
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, tribonacci(new double[]{0, 1, 1}, 10));
    }

}
