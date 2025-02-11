package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/count-primes/

    Đếm các số nguyên tố nhỏ hơn n.
 */
public class CountPrime {

    // Tìm số nguyên tố trong đoạn (a, b)
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        // Đánh dấu các số không phải số nguyên tố
        prime[0] = prime[1] = false;
        // [2 -> sqrt(n)]
        for (int p = 2; p * p <= n; p++) { // p = sqrt(n)
            // Nếu vị trí p vẫn chưa bị đánh dấu, tức p chưa bị đánh đấu là hợp số
            if (prime[p]) {
                // Đánh dấu tất cả các bội số của p (sqrt(n) -> n) là hợp số
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(4, countPrimes(10));
        assertEquals(1, countPrimes(2));
    }

}
