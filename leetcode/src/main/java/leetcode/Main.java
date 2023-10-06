package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * Đếm số phần tử xuất hiện nhiều hơn [n/3] trong mảng
 */
public class Main {

	public int integerBreak(int n) {
		if (n < 4) {
			return n - 1;
		}
		int ans = 1;
		while (n > 4) {
			ans *= 3;
			n -= 3;
		}
		ans *= n;
		return ans;
	}

	@Test
	public void test() {
		assertEquals(36, integerBreak(10));
		// assertEquals(2, integerBreak(10));
	}

}
