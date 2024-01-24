package codewars.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/java
 *
 * Cho tháp số lẻ. Tìm tổng của tầng thứ n
 *
 *              1
 *           3     5
 *        7     9    11
 *    13    15    17    19
 * 21    23    25    27    29
 * ...
 *
 * n = 1 => 1
 * n = 2 => 8 (3 + 5)
 */
public class SumOfOddNumbers {

    public static int rowSumOddNumbers(int n) {
        int sum = 0;
        int currentNumber = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == n) {
                    // System.out.print((2 * currentNumber - 1) + " ");
                    sum += 2 * currentNumber - 1;
                }
                currentNumber++;
            }
            // System.out.println();
        }
        // System.out.println("sum = " + sum);
        return sum;
    }

    @Test
    public void testMax() {
        assertEquals(1, rowSumOddNumbers(1));
        assertEquals(8, rowSumOddNumbers(2));
        assertEquals(27, rowSumOddNumbers(3));
    }

}
