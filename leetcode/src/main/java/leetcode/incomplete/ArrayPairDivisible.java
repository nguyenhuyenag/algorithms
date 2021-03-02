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

	public boolean canArrange(int[] A, int k) {
		int count = 0;
		int stop = A.length / 2;
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		// [1, 2, 3, 4, 5, 10, 6, 7, 8, 9]
		while (list.size() > 0) {
			int[] rm = new int[2];
			for (int i = 0; i < list.size(); i++) {
				int a = list.get(i);
				for (int j = i + 1; j < list.size(); j++) {
					int b = list.get(j);
					if ((a + b) % k == 0) { // a + b chia het cho k
						count++;
						rm[1] = j;
						break;
					}
					if (count == stop) {
						return true;
					}
				}
				if (rm[0] != rm[1]) {
					break;
				}
			}
			if (rm[0] != rm[1]) {
				list.remove(rm[1]);
			}
			list.remove(0);				
		}
		return false;
	}

	@Test
	public void test() {
		// assertEquals(true, canArrange(new int[] { -10, 10 }, 2));
		assertEquals(true, canArrange(new int[] { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }, 5));
		// assertEquals(true, canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 7));
		// assertEquals(false, canArrange(new int[] { 1, 2, 3, 4, 5, 6 }, 10));
		// assertEquals(true, canArrange(new int[] { -1,1,-2,2,-3,3,-4,4 }, 3));
	}

}
