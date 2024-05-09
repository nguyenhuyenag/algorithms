package number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a946d9fba1bb5135100007c/
 *
 * Tìm số nhỏ nhất cần chèn vào mảng sao cho tổng các phần tử là số nguyên tố
 */
public class TransformToPrime {

    public static int minimumNumber(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // Check if the current sum is already a prime number
        if (isPrime(sum)) {
            return 0; // The sum is already prime
        }
        // Find the minimum number to make the sum prime
        for (int i = 1; ; i++) {
            if (isPrime(sum + i)) {
                return i;
            }
        }
    }

    // Check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void checkSmallArraySize() {
        assertEquals(1, TransformToPrime.minimumNumber(new int[]{3, 1, 2}));
        assertEquals(0, TransformToPrime.minimumNumber(new int[]{5, 2}));
        assertEquals(0, TransformToPrime.minimumNumber(new int[]{1, 1, 1}));
    }

    @Test
    public void checkLargerArraySize() {
        assertEquals(5, TransformToPrime.minimumNumber(new int[]{2, 12, 8, 4, 6}));
        assertEquals(2, TransformToPrime.minimumNumber(new int[]{50, 39, 49, 6, 17, 28}));
    }

}
