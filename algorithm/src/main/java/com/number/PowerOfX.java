package com.number;

/**
 * https://leetcode.com/problems/power-of-four/
 *
 * Cho số nguyên N, tìm x sao cho 4^x = n
 */
public class PowerOfX {

	public static boolean isPowerOf4(int n) {
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
	
	public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
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
		// System.out.println(isPowerOfFour(8));
		int i = 0;
		while (i < Integer.MAX_VALUE && Math.pow(3, i) < Integer.MAX_VALUE) {
			System.out.println((int) Math.pow(3, i));
			i++;
		}
	}

}
