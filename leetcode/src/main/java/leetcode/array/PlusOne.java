package leetcode.array;

import java.math.BigInteger;
import java.util.Arrays;

// https://leetcode.com/problems/plus-one/
public class PlusOne {

	public static int[] plusOne1(int[] digits) {
		int ONE = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += ONE;
			if (digits[i] <= 9) {
				return digits;
			}
			digits[i] = 0;
		}
		// [9] => [0] => [1, 0]
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}

	public static int[] plusOne2(int[] digits) {
		int SAVE = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			} else {
				if (SAVE != 0) {
					digits[i] += SAVE;
				}
				digits[i] = 0;
				SAVE = 1;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		return digits;
	}

	public static int[] plusOne(int[] digits) {
		StringBuilder sb = new StringBuilder();
		for (int c : digits) {
			sb.append(c);
		}
		BigInteger big = new BigInteger(sb.toString());
		// System.out.println("N = " + big.intValue());
		big = big.add(BigInteger.ONE);
		// System.out.println("N = " + big.intValue());
		return String.valueOf(big.toString()).chars().map(Character::getNumericValue).toArray();
	}

	public static void main(String[] args) {
		// int[] arr = { 7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1};
		int[] arr = { 9, 9 };
		System.out.println(Arrays.toString(plusOne(arr)));
	}

}
