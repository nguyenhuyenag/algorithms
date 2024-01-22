package leetcode.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * - Quy tắc viết số La Mã là phải cộng, trái trừ
 *
 *	  	AB	:	A < B	=>	A - B
 *	  			A >= B	=>	A + B
 *
 * - Các số: `I, X, C, M` không được phép lặp lại quá 3, các số: `V, L, D` chỉ được xuất hiện 1 lần duy nhất
 */
public class RomanToInteger {
	
	public int of(char roman) {
		return switch (roman) {
			case 'I' -> 1;
			case 'V' -> 5;
			case 'X' -> 10;
			case 'L' -> 50;
			case 'C' -> 100;
			case 'D' -> 500;
			case 'M' -> 1000;
			default -> 0;
		};
    }
	
	public int romanToInt(String str) {
		int len = str.length();
		char[] arr = str.toCharArray();
		int ans = of(arr[len - 1]); 			// Gán s = giá trị số cuối cùng
		for (int i = len - 1; i > 0; i--) {
			int prev = of(arr[i - 1]); 			// Số đứng trước
			if (of(arr[i]) > prev) {
				ans -= prev;					// nhỏ trừ
			} else {
				ans += prev;					// lớn cộng
			}
		}
		return ans;
	}

	@Test
	public void test() {
		assertEquals(3, romanToInt("III"));
		assertEquals(4, romanToInt("IV"));
		assertEquals(9, romanToInt("IX"));
		assertEquals(99, romanToInt("XCIX"));
		assertEquals(58, romanToInt("LVIII"));
		assertEquals(2019, romanToInt("MMXIX"));
		assertEquals(1994, romanToInt("MCMXCIV"));
		assertEquals(1984, romanToInt("MCMLXXXIV"));
	}
	
}
