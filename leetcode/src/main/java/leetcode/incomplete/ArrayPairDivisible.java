
package leetcode.incomplete;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 */
public class ArrayPairDivisible {

	public int[] findPair(List<Integer> list, int k) {
		int n = list.size();
		int stop = n / 2;
		for (int i = 0; i < n; i++) {
			int a = list.get(i);
			if (i >= stop) {
				return new int[] { -1, -1 };
			}
			for (int j = i + 1; j < n; j++) {
				int b = list.get(j);
				if ((a + b) % k == 0) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public boolean canArrange(int[] A, int k) {
		int count = 0;
		int stop = A.length / 2;
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		while (list.size() > 0) {
			int[] pair = findPair(list, k);
			if (pair[0] != -1) {
				count++;
				if (count == stop) {
					return true;
				}
				list.remove(pair[1]);
				list.remove(pair[0]);
			} else {
				return false;
			}
		}
		return false;
	}

	@Test
	public void test() {
		assertEquals(true, canArrange(new int[] { -10, 10 }, 2));
		assertEquals(true, canArrange(new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }, 5));
		assertEquals(true, canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
		assertEquals(false, canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 10));
		assertEquals(true, canArrange(new int[] { -1, 1, -2, 2, -3, 3, -4, 4 }, 3));
	}

}
