package leetcode.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*-
 * - Given a non-empty array of integers, return the k most frequent elements
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class KFrequent {

	private int number;
	private int count;

	public KFrequent(int number, int count) {
		this.number = number;
		this.count = count;
	}

	public int getNumber() {
		return number;
	}

	public int getCount() {
		return count;
	}

}

public class TopKFrequentElement {

	public static int[] topKFrequent(int[] A, int k) {
		List<KFrequent> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int count = 1;
			if (set.add(A[i])) {
				for (int j = i + 1; j < n; j++) {
					if (A[i] == A[j]) {
						count++;
					}
				}
				list.add(new KFrequent(A[i], count));
			}
		}
		Collections.sort(list, (k1, k2) -> k2.getCount() - k1.getCount());
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = list.get(i).getNumber();
		}
		return res;
	}

	@Test
	public void test() {
		assertArrayEquals(new int[] { 1 }, topKFrequent(new int[] { 1 }, 1));
		assertArrayEquals(new int[] { 1, 2 }, topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
	}

}
