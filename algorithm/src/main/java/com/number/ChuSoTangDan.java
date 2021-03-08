package com.number;

/**
 * Kiểm tra các chữ số tăng dần
 */
public class ChuSoTangDan {

	public static void main(String[] args) {
		int n = 112356;
		int prev, end = n % 10;
		n /= 10;
		while (n > 0) {
			prev = n % 10;
			n /= 10;
			if (prev >= end) {
				System.out.println("NO");
				return;
			}
			end = prev;
		}
		System.out.println("YES");
	}

}
