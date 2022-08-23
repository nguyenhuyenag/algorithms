package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*-
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * - Given a non-empty array of integers, return the k most frequent elements
 */
//class KFrequent {
//
//	private int number;
//	private int count;
//
//	public KFrequent(int number, int count) {
//		this.number = number;
//		this.count = count;
//	}
//
//	public int getNumber() {
//		return number;
//	}
//
//	public int getCount() {
//		return count;
//	}
//
//}

public class TopKFrequentElement {

//	public static int[] topKFrequent2(int[] A, int k) {
//		List<KFrequent> list = new ArrayList<>();
//		Set<Integer> set = new HashSet<>();
//		int n = A.length;
//		for (int i = 0; i < n; i++) {
//			int count = 1;
//			if (set.add(A[i])) {
//				for (int j = i + 1; j < n; j++) {
//					if (A[i] == A[j]) {
//						count++;
//					}
//				}
//				list.add(new KFrequent(A[i], count));
//			}
//		}
//		Collections.sort(list, (k1, k2) -> k2.getCount() - k1.getCount());
//		int[] res = new int[k];
//		for (int i = 0; i < k; i++) {
//			res[i] = list.get(i).getNumber();
//		}
//		return res;
//	}

	public static int[] topKFrequent(int[] A, int k) {
		int n = A.length;
		int[] mark = new int[n];
		Arrays.fill(mark, 0);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int count = 1;
			if (mark[i] == 0) {
				for (int j = i + 1; j < n; j++) {
					if (A[i] == A[j]) {
						count++;
						mark[j] = 1;
					}
				}
				map.put(A[i], count);
			}
			mark[i] = 1;
		}
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = list.get(i).getKey();
		}
		return res;
	}

//	@Test
//	public void test() {
//		assertArrayEquals(new int[] { 1 }, topKFrequent(new int[] { 1 }, 1));
//		assertArrayEquals(new int[] { 1, 2 }, topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
//	}

	public static void main(String[] args) {
		topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
	}

}
