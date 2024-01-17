package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/61a498cf085ad00051190591/
 *
 * Tìm số nguyên không âm lớn nhất có tổng = k sao cho mỗi chữ số chỉ xuất hiện 1 lần
 */
public class MainWar {

    public static int findLargestNumber(int k) {
        if (k == 1) {
            return 10;
        }

        if (k < 0 || k > 45) return -1;

        int[] result = new int[1];
        boolean[] usedDigits = new boolean[10];

        findLargestNumberHelper(k, 0, usedDigits, result);

        return result[0];
    }

    private static void findLargestNumberHelper(int k, int currentNumber, boolean[] usedDigits, int[] result) {
        if (sumOfDigits(currentNumber) == k) {
            result[0] = Math.max(result[0], currentNumber);
            return;
        }

        for (int digit = 9; digit > 0; digit--) {
            if (!usedDigits[digit]) {
                int nextNumber = currentNumber * 10 + digit;
                usedDigits[digit] = true;
                findLargestNumberHelper(k, nextNumber, usedDigits, result);
                usedDigits[digit] = false;
            }
        }
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static long max(int x) {
        int largestNumber = findLargestNumber(x);
        if (!String.valueOf(largestNumber).contains("0")) {
            return largestNumber * 10;
        }
        return largestNumber;
    }

    @Test
    public void testMax() {
        assertEquals(8543210, max(23));
        assertEquals(953210, max(20));
        assertEquals(98743210, max(34));
    }

    // corner input,
    @Test
    public void testMaxCorner() {
        assertEquals(0, max(0));
        assertEquals(10, max(1));
        assertEquals(9876543210L, max(45));
    }

    // invalid input,
    @Test
    public void testMaxInvalid() {
        assertEquals(-1, max(-1));
        assertEquals(-1, max(46));
    }

}
