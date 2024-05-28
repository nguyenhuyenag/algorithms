package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/super-ugly-number/description/

    Cho mảng primes chứa các số nguyên tố. Số siêu xấu là số mà các thừa số
    nguyên tố của nó đều nằm trong mảng primes. Tìm số siêu xấu thứ n-th.
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        // Convert the array of primes to a set for quick lookup
        Set<Integer> primesSet = Arrays.stream(primes).boxed().collect(Collectors.toSet());

        // Initialize count and i
        int count = 0;
        int i = 1; // Start from 1 because 0 is not a valid positive integer

        // Loop until we find the nth super ugly number
        while (count < n) {
            int temp = i; // Temporary variable to hold the value of i
            boolean check = true; // Flag to check if all factors are in the primes set

            // Check prime factors of i
            for (int j = 2; j * j <= temp; j++) {
                while (temp % j == 0) {
                    // If the factor is not in the primes set, mark check as false
                    if (!primesSet.contains(j)) {
                        check = false;
                        break;
                    }
                    temp /= j;
                }
                // Break outer loop if a factor not in primes set is found
                if (!check) {
                    break;
                }
            }

            // If the remaining number is greater than 1, it should be in the primes set
            if (temp > 1 && !primesSet.contains(temp)) {
                check = false;
            }

            // If all factors are valid, increment count
            if (check) {
                count++;
            }

            // Move to the next number
            i++;
        }

        // Return the n-th super ugly number (subtract 1 because i was incremented one extra time)
        return i - 1;
    }

    @Test
    public void test() {
        assertEquals(32, nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        assertEquals(1, nthSuperUglyNumber(1, new int[]{2, 3, 5}));
    }

}
