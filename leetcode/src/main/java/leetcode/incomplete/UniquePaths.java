//package leetcode.incomplete;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//// https://leetcode.com/problems/unique-paths/
//public class UniquePaths {
//
//	public int uniquePaths(int m, int n) {
//		int[] M = new int[m];
//		M[0] = 1;
//		for (int i = 0; i < n; i++) {
//			for (int j = 1; j < m; j++) {
//				M[j] += M[j - 1];
//			}
//		}
//		return M[m - 1];
//	}
//
//	@Test
//	public void test() {
//		assertEquals(28, uniquePaths(3, 7));
//		assertEquals(3, uniquePaths(3, 2));
//		assertEquals(28, uniquePaths(7, 3));
//		assertEquals(6, uniquePaths(3, 3));
//		assertEquals(20, uniquePaths(4, 4));
//	}
//
//}
