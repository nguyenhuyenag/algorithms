package number;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

    Với mỗi số nguyên n -> binary(n) -> bitCount -> Nếu số bit là số nguyên tố thì -> true

    Đếm số nguyên có bitCount là số nguyên tố trong đoạn [x, y] cho trước.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public boolean primeCheck(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bitCount = Integer.bitCount(i);
            if (primeCheck(bitCount)) {
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(4, countPrimeSetBits(6, 10));
    }

}
