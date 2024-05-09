package array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://www.codewars.com/kata/54da5a58ea159efa38000836/
 * 
 * Tìm phần tử có số lần xuất hiện là lẻ (frequency) trong mảng
 */
public class FindTheOddInt {

	public static int findIt(int[] arr) {
		Map<Integer, Integer> numsCount = new HashMap<>();
		for (int x : arr) {
			numsCount.put(x, numsCount.getOrDefault(x, 0) + 1);
		}
		// System.out.println(numsCount);
		for (Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				return entry.getKey();
			}
		}
		return -1;
	}

	@Test
	public void testSomething() {
		assertEquals(5, findIt(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
		assertEquals(-1, findIt(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
		assertEquals(5, findIt(new int[] { 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 }));
		assertEquals(10, findIt(new int[] { 10 }));
		assertEquals(10, findIt(new int[] { 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 }));
		assertEquals(1, findIt(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 }));
	}

}
