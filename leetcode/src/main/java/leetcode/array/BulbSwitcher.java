package leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/bulb-switcher/
public class BulbSwitcher {

	public static int count(boolean[] arr) {
		int count = 0;
		for (boolean v : arr) {
			if (v) {
				count++;
			}
		}
		return count;
	}

	public int bulbSwitch(int n) {
		boolean[] bulbs = new boolean[n];
		Arrays.fill(bulbs, true); // step 1
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j += i + 1) {
				bulbs[j] = !bulbs[j]; // toggle every i-th bulb
			}
		}
		return count(bulbs);
	}

	@Test
	public void test() {
		// assertEquals(1, bulbSwitch(3));
		// assertEquals(0, bulbSwitch(0));
		// assertEquals(1, bulbSwitch(1));
		assertEquals(2, bulbSwitch(4));
	}

}
