package leetcode.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*-
 * Ta sẽ tạo 1 mảng gồm n số ugly từ số ugly đầu tiên là 1, bằng cách nhân lần lượt cho 2, 3, 5
 * và mỗi bước ta sẽ chọn số nhỏ nhất
 * 
 * k_1 = min(2k_0, 3k_0, 5k_0) = 2k_0 = 2. So we move p2 pointer to 1.
 * 
 * k_2 = min(2k_1, 3k_0, 5k_0) = 3k_0 = 3. So we move p3 pointer to 1, ...
 * 
 * https://leetcode.com/problems/ugly-number-iii/
 */
public class UglyNumberII {

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	public static int nthUglyNumber(int n, int a, int b, int c) {
		int p2 = 0, p3 = 0, p5 = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = min(a * dp[p2], b * dp[p3], c * dp[p5]);
			if (dp[i] == a * dp[p2]) p2++; 
			if (dp[i] == b * dp[p3]) p3++; 
			if (dp[i] == c * dp[p5]) p5++;
		}
		return dp[n - 1];
	}

	@Test
	public void test() {
		assertEquals(12, nthUglyNumber(10, 2, 3, 5));
	}

}
