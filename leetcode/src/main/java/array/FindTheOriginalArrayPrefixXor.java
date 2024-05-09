package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 * 
 * Tính: pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]
 */
public class FindTheOriginalArrayPrefixXor {

	public static int[] findArray0(int[] pref) {
		int[] ans = new int[pref.length];
		for (int i = 0; i < pref.length; i++) {
			ans[i] = pref[i] ^ ((i > 0) ? pref[i - 1] : 0);
		}
		return ans;
	}

	public int[] findArray1(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] ^= arr[i - 1];
		}
		return arr;
	}

	public int[] findArray(int[] arr) {
		return findArray0(arr);
	}

	@Test
	public void test() {
		// assertArrayEquals(new int[] { 13 }, findArray(new int[] { 13 }));
		assertArrayEquals(new int[] { 5, 7, 2, 3, 2 }, findArray(new int[] { 5, 2, 0, 3, 1 }));
	}

}
