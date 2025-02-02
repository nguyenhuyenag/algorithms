package incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/prime-palindrome/

    Tìm số nguyên tố đối xứng nhỏ nhất >= n.
 */
public class PrimePalindrome {

    public int reverse(int n) {
        int result = 0;
        while (n > 0) {
            result = 10 * result + n % 10;
            n = n / 10;
        }
        return result;
    }

    public boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int primePalindrome(int n) {
        while (!(isPalindrome(n) && isPrime(n))) {
            n++;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(7, primePalindrome(6));
    }

}
