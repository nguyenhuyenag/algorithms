package leetcode;

import java.util.BitSet;

// https://leetcode.com/problems/powx-n
public class Main {

	public static double cal(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? cal(x * x, n / 2) : x * cal(x * x, n / 2);
	}

	public static double myPow(double x, int n) {
		return cal(x, n + 0l);
	}

	public static boolean checkIfPangram(String str) {
		int[] marks = new int[25];
		for (int i = 0; i < str.length(); i++) {

		}
		return true;
	}

	// a - z: 26 ký tự
	public static void main(String[] args) {
		// int[] marks = new int[25];
		String str = "leetcode";
		BitSet[] alphabet = new BitSet[26];
		for (char c : str.toCharArray()) {
			// System.out.println(c - 'a');
			// alphabet.set(alphabet[c - 'a']);
			// alphabet[c - 'a']
		}
		//
		BitSet bits1 = new BitSet(16);
		BitSet bits2 = new BitSet(16);

		// thiet la mot so bit
		for (int i = 0; i < 16; i++) {
			if (i % 2 == 0)
				bits1.set(i);
			if (i % 5 != 0)
				bits2.set(i);
		}
		// System.out.println("Pattern ban dau trong bits1: ");
		System.out.println("bits1: " + bits1);
		// System.out.println("\nPattern ban dau trong bits2: ");
		System.out.println("bits2: " + bits2);

		// AND bits
		bits2.and(bits1);
		System.out.println("\nbits2 AND bits1: ");
		System.out.println(bits2);

		// OR bits
		bits2.or(bits1);
		System.out.println("\nbits2 OR bits1: ");
		System.out.println(bits2);

		// XOR bits
		bits2.xor(bits1);
		System.out.println("\nbits2 XOR bits1: ");
		System.out.println(bits2);
	}

}
