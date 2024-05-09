package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a946d9fba1bb5135100007c/
 *
 * Tìm số nguyên nhỏ nhất chèn vào mảng sao cho sum(arr) gần với số nguyên tố
 */
public class TransformToPrime {

    public static boolean isPrime(int n) {
        if (n == 2 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int minimumNumber(int[] nums) {
        // Sum of all elements in the array
        int sum = Arrays.stream(nums).sum();
        // Tìm số nguyên tố > sum
        for (int i = sum; true; i++) {
            if (isPrime(i)) {
                return i - sum;
            }
        }
    }

    public static int minimumNumber0(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int snext = sum;
        while (true) {
            if (isPrime(snext)) {
                return snext - sum;
            }
            snext++;
        }
    }

    @Test
    public void checkSmallArraySize() {
        assertEquals(1, minimumNumber(new int[]{3, 1, 2}));
        assertEquals(0, minimumNumber(new int[]{5, 2}));
        assertEquals(0, minimumNumber(new int[]{1, 1, 1}));
    }

    @Test
    public void checkLargerArraySize() {
        assertEquals(5, minimumNumber(new int[]{2, 12, 8, 4, 6}));
        assertEquals(2, minimumNumber(new int[]{50, 39, 49, 6, 17, 28}));
    }

}
