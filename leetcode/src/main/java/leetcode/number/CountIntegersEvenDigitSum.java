package leetcode.number;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 * 
 * Đếm số phần tử < num và tổng các chữ số là số chẵn
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
				// System.out.println(i);
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
