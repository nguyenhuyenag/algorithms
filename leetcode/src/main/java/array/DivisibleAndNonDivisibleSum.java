package array;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/

    You are given positive integers n and m.

    Define two integers, num1 and num2, as follows:

        num1: The sum of all integers in the range [1, n] that are not divisible by m.

        num2: The sum of all integers in the range [1, n] that are divisible by m.

    Return the integer num1 - num2.
 */
public class DivisibleAndNonDivisibleSum {

    public int differenceOfSums(int n, int m) {
        int num1 = IntStream.rangeClosed(1, n)
                .filter(x -> x % m != 0)
                .sum();

        int num2 = IntStream.rangeClosed(1, n)
                .filter(x -> x % m == 0)
                .sum();

        return num1 - num2;
    }

    @Test
    public void test() {
        assertEquals(19, differenceOfSums(10, 3));
    }

}
