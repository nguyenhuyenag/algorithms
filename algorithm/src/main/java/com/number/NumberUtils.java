package com.number;

public class NumberUtils {

	/**
	 * Thập phân => nhị phân
	 */
	public static String toBinary(int n) {
		String s = "";
		while (n != 0) {
			s = n % 2 + s;
			n = n / 2;
		}
		return s; // return Integer.toBinaryString(n);
	}

	public static String toBinary0(int sum) {
		StringBuilder binary = new StringBuilder();
		if (sum == 0) {
			return "0";
		}
		while (sum > 0) {
			int remainder = sum % 2;
			binary.insert(0, remainder);
			sum /= 2;
		}
		return binary.toString();
	}
	
	/**
	 * Nhị phân => thập phân
	 */
	public static int binaryToDecimal(String binary) {
		return Integer.parseInt(binary, 2);
	}

	/**
	 * Tổng các chữ số
	 */
	public static int sumDigit(int n) {
		int s = 0;
		while (n != 0) {
			s += n % 10;
			n /= 10;
		}
		return s;
	}

	/**
	 * Chữ số đầu tiên
	 */
	public static int firstDigit(int n) {
		while (n > 10) {
			n /= 10;
		}
		return n;
	}

	/**
	 * Đảo ngược số
	 */
	public static int reverseNumber(int n) {
		int rev = 0;
		while (n > 0) {
			// b = n % 10 => Lấy chữ số ra
			// thêm vào hàng đơn vị
			// ab = 10 * a + b
			rev = rev * 10 + n % 10;
			n = n / 10;
		}
		return rev;
	}

	/**
	 * Kiểm tra các chữ số có phải tăng dần
	 */
	public static boolean increment(int n) {
		int tmp, end = n % 10;
		n /= 10;
		while (n > 0) {
			tmp = n % 10;
			if (tmp > end) {
				return false;
			}
			end = tmp;
			n /= 10;
		}
		return true;
	}

	/**
	 * Ước chung lớn nhất: Euclid
	 */
	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a; // hay b cũng được vì lúc này a = b
	}
	
	// n là lũy thừa của k: k^i = n
	public static boolean isPowerOfAny(int n, int k) {
		if (n <= 0) {
			return false;
		}
		while (n > 1) {
			if (n % k == 0) {
				n /= k;
			} else {
				return false;
			}
		}
		return true;
	}

}
