package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://vnoi.info/wiki/algo/algebra/primality_check.md
 */
public class PrimeNumber {

    public static boolean primeCheck(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Tìm số nguyên tố trong đoạn (a, b)
    public static void sieveOfEratosthenes(int n) {
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
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    // Phân tích một số ra thừa số nguyên tố
    public static void primeFactorization(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                result.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            result.add(n);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // primeCheck(19);
        // sieveOfEratosthenes(10);
        primeFactorization(34);
    }

}




