package codewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5526fc09a1bbd946250002dc/
 * 
 * Tìm số ngoại lai:
 * 
 * [2, 4, 0, 100, 4, 11, 2602, 36] --> 11 (the only odd number)
 * 
 * [160, 3, 1719, 19, 11, 13, -21] --> 160 (the only even number)
 */
public class WarMain {

	public static int find(int[] nums) {
		int len = nums.length;

		boolean[] mark = new boolean[len];
		for (int i = 0; i < len; i++) {
			mark[i] = nums[i] % 2 == 0;
		}

		// System.out.println(Arrays.toString(mark));

		int countTrue = 0;
		int countFalse = 0;
		for (int i = 0; i < len; i++) {
			if (mark[i]) {
				countTrue++;
			} else {
				countFalse++;
			}
		}
		// System.out.println(countTrue + ", " + countFalse);
		if (countTrue > 1) { // -> false là phần tử cần tìm
			for (int i = 0; i < len; i++) {
				if (!mark[i]) {
					return nums[i];
				}
			}
		}
		if (countFalse > 1) { // -> true là phần tử cần tìm
			for (int i = 0; i < len; i++) {
				if (mark[i]) {
					return nums[i];
				}
			}
		}
		return -1;
	}

	@Test
	public void doTest() {
		assertEquals(11, find(new int[] { 2, 4, 0, 100, 4, 11, 2602, 36 }));
		assertEquals(160, find(new int[] { 160, 3, 1719, 19, 11, 13, -21 }));
		assertEquals(3, find(new int[] { 2, 6, 8, -10, 3 }));
		assertEquals(206847684, find(new int[] { 206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781 }));
		assertEquals(0, find(new int[] { Integer.MAX_VALUE, 0, 1 }));
	}

}
