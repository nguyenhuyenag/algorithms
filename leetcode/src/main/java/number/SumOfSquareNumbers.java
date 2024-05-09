package number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Chủ đề: Two pointer
 *
 * https://leetcode.com/problems/sum-of-square-numbers/
 * 
 * Cho số nguyên c, kiểm tra số xem c = a^2 + b^2
 */
public class SumOfSquareNumbers {

	public boolean judgeSquareSum(long c) {
		for (long a = 0; a <= Math.sqrt(c); a++) {
			long bSquare = c - a * a;
			long b = (long) Math.sqrt(bSquare);
			if (b * b == bSquare) {
				return true;
			}
		}
		return false;
	}

	public boolean judgeSquareSum0(int c) {
		long a = 0;
		long b = (long) Math.sqrt(c); // Giá trị lớn nhất mà b có thể đạt được
		while (a <= b) {
			if (a * a + b * b < c) {
				// Tổng nhỏ hơn thì tăng a
				a++;
			} else if (a * a + b * b > c) {
				// Tổng lớn hơn thì giảm
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
