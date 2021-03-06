package leetcode.incomplete;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBit {
	
	public int reverseBits2(int n) {
		return Integer.reverse(n);
	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		String b = Integer.toBinaryString(n);
		StringBuilder sb = new StringBuilder(b).reverse();
		return Integer.parseInt(sb.toString(), 2);
	}

	@Test
	public void test() {
		assertEquals(13, reverseBits(11));
	}

	public static void main(String[] args) {
		String s = "11111111111111111111111111111101";
		// System.out.println(Integer.parseInt(s, 2));
		StringBuilder sb = new StringBuilder(s).reverse();
		System.out.println(Integer.parseInt(sb.toString(), 2));
	}

}
