package leetcode.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/binary-number-with-alternating-bits/
public class BinaryAlternatingBit {

	public static boolean hasAlternatingBits(int n) {
		String binary = Integer.toBinaryString(n);
		if (binary.charAt(0) == '0') { // a0 = 0
			// a_chẵn = 0, a_lẻ = 1
			for (int i = 1; i < binary.length(); i++) {
				if (i % 2 == 0 && binary.charAt(i) != '0') {
					return false;
				}
				if (i % 2 != 0 && binary.charAt(i) != '1') {
					return false;
				}
			}
		} else { // a0 = 1
			// a_chẵn = 1, a_lẻ = 0
			for (int i = 1; i < binary.length(); i++) {
				if (i % 2 == 0 && binary.charAt(i) != '1') {
					return false;
				}
				if (i % 2 != 0 && binary.charAt(i) != '0') {
					return false;
				}
			}
		}
		return true;
	}

	@Test
	public void test() {
		assertEquals(true, hasAlternatingBits(5));
		assertEquals(false, hasAlternatingBits(7));
		assertEquals(false, hasAlternatingBits(11));
		assertEquals(true, hasAlternatingBits(10));
		assertEquals(false, hasAlternatingBits(3));
	}

}
