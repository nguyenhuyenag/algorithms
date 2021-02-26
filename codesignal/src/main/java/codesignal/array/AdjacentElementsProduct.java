package codesignal.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://app.codesignal.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m
public class AdjacentElementsProduct {

	int adjacentElementsProduct(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			int t = A[i] * A[i + 1];
			if (t > max) {
				max = t;
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals(21, adjacentElementsProduct(new int[] { 3, 6, -2, -5, 7, 3 }));
		assertEquals(2, adjacentElementsProduct(new int[] { -1, -2 }));
		assertEquals(6, adjacentElementsProduct(new int[] { 5, 1, 2, 3, 1, 4 }));
		assertEquals(50, adjacentElementsProduct(new int[] { 9, 5, 10, 2, 24, -1, -48 }));
		assertEquals(30, adjacentElementsProduct(new int[] { 5, 6, -4, 2, 3, 2, -23 }));
		assertEquals(30, adjacentElementsProduct(new int[] { 5, 6, -4, 2, 3, 2, -23 }));
		assertEquals(6, adjacentElementsProduct(new int[] { 4, 1, 2, 3, 1, 5 }));
	}

}
