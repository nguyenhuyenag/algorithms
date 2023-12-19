package codewars.incomplete;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
public class MaximumSubarraySum {

	public static int sequence(int[] arr) {
		int max = 0, csum = 0;
		for (int x : arr) {
			csum = Math.max(0, csum + x);
			max = Math.max(max, csum);
		}
		return max;
	}

	@Test
	public void testEmptyArray() throws Exception {
		// assertEquals("Empty arrays should have a max of 0", 0, sequence(new int[]
		// {}));
		assertEquals(7, sequence(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
		assertEquals(6, sequence(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

}
