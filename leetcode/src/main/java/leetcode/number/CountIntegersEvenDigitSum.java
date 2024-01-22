package leetcode.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 *
 * Cho số nguyên dương n. Đếm số phần tử < n và tổng các chữ số của nó là số chẵn
 */
public class CountIntegersEvenDigitSum {

    public int sumDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int countEven(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (sumDigit(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countEven(4));
        assertEquals(14, countEven(30));
    }

}
