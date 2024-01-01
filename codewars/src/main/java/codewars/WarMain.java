package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

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

		System.out.println(Arrays.toString(mark));

		boolean firstValue = mark[0];
		for (int i = 1; i < len; i++) {
			if (firstValue) { // Nếu firstValue = true
				if (firstValue != mark[i]) {
					return nums[i];
				}
			} else { // Nếu firstValue = false
				
			}
		}
		return 11;
	}

	@Test
	public void doTest() {
		assertEquals(11, find(new int[] { 2, 4, 0, 100, 4, 11, 2602, 36 }));
		assertEquals(160, find(new int[] { 160, 3, 1719, 19, 11, 13, -21 }));
	}

}
