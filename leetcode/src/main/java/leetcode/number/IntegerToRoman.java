package leetcode.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * Trừ tham lam như bài toán thối tiền
 * 
 * Nếu n >= v[i] thì in ra s[i] và trừ v[i] cho n tới khi n < v[i], tiếp tục tới khi n = 0 thì dừng 
 * 
 * Ví dụ 1234:
 * 
 * 	1234 > 1000, in ra M, trừ 1000 còn 234
 * 
 * 	234 < 900, ko in ko trừ
 * 
 * 	234 < 500, ko in ko trừ
 * 
 * 	234 < 400, ko in ko trừ
 * 
 * 	234 > 100, in ra C, trừ 100 còn 134; 134 > 100, in ra C, trừ 100 còn 34
 * 
 * 	34 < 90, ko in ko trừ
 * 
 * 	34 < 50, ko in ko trừ
 * 
 * 	34 < 40, ko in ko trừ
 * 
 * 	34 > 10, in ra X, trừ 10 còn 24; 24 > 100, in ra X, trừ 10 còn 14; 14 > 100, in ra X, trừ 10 còn 4
 * 
 * 	4 >= 4, in ra IV, trừ 4 còn 0, kết thúc
 * 
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

	public String intToRoman(int n) {
		int[] V = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] R = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int len = V.length;
		StringBuilder s = new StringBuilder();
		while (n > 0) {
			for (int i = 0; i < len; i++) {
				if (n >= V[i]) {
					s.append(R[i]);
					n -= V[i];
					break;
				}
			}
		}
		return s.toString();
	}

	@Test
	public void test() {
		// assertEquals("MCMXCIV", intToRoman(1994));
		// assertEquals("I", intToRoman(1));
		// assertEquals("IV", intToRoman(4));
		// assertEquals("VIII", intToRoman(8));
		// assertEquals("XI", intToRoman(11));
		// assertEquals("LVIII", intToRoman(58));
		assertEquals("MCCXXXIV", intToRoman(1234));
		assertEquals("CM", intToRoman(900));
	}

}
