package leetcode.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * - Quy tắc viết số La Mã là phải cộng, trái trừ
 * 	
 *	  	AB	:	A < B	=>	A - B
 *	  			A >= B	=>	A + B
 * 
 * - Các số: `I, X, C, M` không được phép lặp lại quá 3, các số: `V, L, D` chỉ được xuất hiện 1 lần duy nhất
 * 
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
	
	static int of(char roman) {
		switch (roman) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
	
	public static int romanToInt(String str) {
		int n = str.length();
		char[] A = str.toCharArray();
		int s = of(A[n - 1]); 				// Gán s = giá trị số cuối cùng
		for (int i = n - 1; i > 0; i--) {
			int prev = of(A[i - 1]); 		// Số đứng trước
			if (of(A[i]) > prev) { 			
				s -= prev;					// nhỏ trừ
			} else {
				s += prev;					// lớn cộng
			}
		}
		return s;
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
