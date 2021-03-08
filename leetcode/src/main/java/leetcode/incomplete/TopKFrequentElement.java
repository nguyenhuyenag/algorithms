package leetcode.incomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*-
 * - Given a non-empty array of integers, return the k most frequent elements.
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElement {

	public static int[] topKFrequent(int[] A, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int count = 1;
			if (!list.contains(A[i])) {
				for (int j = i + 1; j < n; j++) {
					if (A[i] == A[j]) {
						count++;
					}
				}
				map.put(count, A[i]);
			}
		}
		int i = 0;
		int[] res = new int[k];
		System.out.println(map.entrySet());
		map.entrySet().forEach(t -> {
			res[i] = t.getValue();
			//i++;
		});
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2, 2, 3 };
		topKFrequent(A, 2);
	}

}
