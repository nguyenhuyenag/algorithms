package number;

import java.util.*;

/**
 * https://blog.28tech.com.vn/sang-so-nguyen-to
 * https://vnoi.info/wiki/algo/algebra/primality_check.md
 * https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif
 *
 * Nếu tất cả các số nguyên trong đoạn [2, sqrt(n)] đều không phải là ước của n thì n là số nguyên tố.
 */
public class PrimeNumber {

    public static boolean primeCheck(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Tìm số nguyên tố trong đoạn (2, n)
    public static void sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        // Đánh dấu các số không phải số nguyên tố
        prime[0] = prime[1] = false;

        // Duyệt trong khoảng: [2, sqrt(n)]
        for (int p = 2; p * p <= n; p++) { // p = sqrt(n)
            // Nếu vị trí p vẫn chưa bị đánh dấu (p chưa bị đánh dấu là hợp số)
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
        var result = new ArrayList<>();
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

    // Phân tích một số ra thừa số nguyên tố theo định dạng (p1**k1)(p2**k2)...(pn**kn)
    public static String factors(int n) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> primeFactors = new LinkedHashMap<>();
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            primeFactors.put(n, primeFactors.getOrDefault(n, 0) + 1);
        }
        primeFactors.forEach((prime, count) -> {
            if (count > 1) {
                result.append("(").append(prime).append("**").append(count).append(")");
            } else {
                result.append("(").append(prime).append(")");
            }
        });
        return result.toString();
    }

    public static void main(String[] args) {
        // primeCheck(19);
        sieveOfEratosthenes(100);
        // primeFactorization(11223344);
    }

}
