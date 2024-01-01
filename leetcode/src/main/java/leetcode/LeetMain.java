package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Chủ đề: Two pointer
 * 
 * https://leetcode.com/problems/sum-of-square-numbers/
 * 
 * Kiểm tra số xem c = a^2 + b^2
 */
public class LeetMain {

//	public boolean judgeSquareSum0(long c) {
//		for (long a = 0; a * a <= c; a++) {
//			long bSquare = c - a * a;
//			long b = (long) Math.sqrt(bSquare);
//			if (b * b == bSquare) {
//				return true;
//			}
//		}
//		return false;
//	}

	public boolean judgeSquareSum(int c) {
		long a = 0;
		long b = (long) Math.sqrt(c);
		while (a <= b) {
			long sum = a * a + b * b;
			if (sum == c) {
				return true;
			} else 
				if (sum < c) {
					a++;
				} else { // sum > c
					b--;
				}
		}
		return false;
	}

	@Test
	public void testSomething() {
		assertEquals(true, judgeSquareSum(25));
	}

}
