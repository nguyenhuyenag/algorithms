package leetcode.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

	public static int sumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

//	public int addDigits1(int n) {
//		while (true) {
//			n = sumOfDigits(n);
//			if (n < 10) {
//				break;
//			}
//		}
//		return n;
//	}

	public int addDigits2(int n) {
		while (n >= 10) {
			int sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;
		}
		return n;
	}

	public int addDigits3(int n) {
		while (n >= 10) {
			n = n / 10 + n % 10;
		}
		return n;
	}

	/**
	 * ABCD = 1000A+100B+10*C+D = (A + B + C + D) + 9 * (111 * A + 11 * B + C) this
	 * equals (mod 9) to A + B + C + D
	 */
	public int addDigits4(int n) {
		if (n == 0) {
			return 0;
		}
		if (n % 9 == 0) {
			return 9;
		}
		return n % 9;
	}

	@Test
	public void test1() {
		int n = 125564;
		assertEquals((addDigits2(n)), addDigits4(38));
		// assertEquals(0, addDigits3(0));
	}

}
