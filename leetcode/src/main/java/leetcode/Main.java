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
			System.out.println(c - 'a');
			// alphabet.set(alphabet[c - 'a']);
			// alphabet[c - 'a'].get(bitIndex)
		}
		// BitSet bs = new BitSet(1);
		// System.out.println(bs.get(0));
	}

}
