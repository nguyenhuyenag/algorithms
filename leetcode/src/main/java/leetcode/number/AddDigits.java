package leetcode.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddDigits {

	public static int sumOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	public int addDigits1(int n) {
		while (true) {
			n = sumOfDigits(n);
			if (n < 10) {
				break;
			}
		}
		return n;
	}

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

	@Test
	public void test1() {
		// assertEquals(2, addDigits(38));
		assertEquals(0, addDigits3(0));
	}

}
