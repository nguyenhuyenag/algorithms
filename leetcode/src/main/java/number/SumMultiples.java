package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/sum-multiples/

    Cho số nguyên dương n. Tính tổng các số thuộc [1, n] mà số đó chi hết cho 3, 5 hoặc 7.
 */
public class SumMultiples {

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(40, sumOfMultiples(10));
        assertEquals(30, sumOfMultiples(9));
    }

}
