package leetcode.number;

// https://leetcode.com/problems/power-of-four/
public class PowerofFour {

	public static boolean isPowerOfFour(int n) {
		if (n <= 0) {
			return false;
		}
		while (n > 1) {
			if (n % 4 == 0) {
				n /= 4;
			} else {
				return false;
			}
		}
		return true;
	}

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

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(8));
	}

}
