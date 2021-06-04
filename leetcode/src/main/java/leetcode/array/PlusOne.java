package leetcode.array;

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

	public static int[] plusOne(int[] digits) {
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

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 8 };
		int[] arr = { 9, 9 };
		System.out.println(Arrays.toString(plusOne(arr)));
	}

}
