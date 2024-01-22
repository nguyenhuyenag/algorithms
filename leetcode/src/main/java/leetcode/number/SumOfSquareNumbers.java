package leetcode.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 * 
 * Cho số nguyên c, kiểm tra số xem c = a^2 + b^2
 */
public class SumOfSquareNumbers {

	public boolean judgeSquareSum0(long c) {
		for (long a = 0; a * a <= c; a++) {
			long bSquare = c - a * a;
			long b = (long) Math.sqrt(bSquare);
			if (b * b == bSquare) {
				return true;
			}
		}
		return false;
	}

	public boolean judgeSquareSum(int c) {
		long a = 0;
		long b = (long) Math.sqrt(c);
		while (a <= b) {
			if (a * a + b * b < c) {
				a++;
			} else if (a * a + b * b > c) {
				b--;
			} else { // a * a + b * b == c
				return true;
			}
		}
		return false;
	}

	@Test
	public void testSomething() {
		assertEquals(true, judgeSquareSum(25));
		assertEquals(false, judgeSquareSum(24));
		assertEquals(true, judgeSquareSum(49));
	}

}
