package leetcode.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
 * 
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

	public boolean isUgly(int n) {
		if (n == 0) {
			return false;
		}
		int[] divisors = { 2, 3, 5 };
		for (int d : divisors) {
			while (n % d == 0) {
				n /= d;
			}
		}
		return n == 1;
	}

	@Test
	public void test() {
		assertEquals(true, isUgly(1));
		assertEquals(true, isUgly(6));
		assertEquals(true, isUgly(8));
		assertEquals(false, isUgly(14));
	}

}
