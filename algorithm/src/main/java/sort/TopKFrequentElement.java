package sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Cho mảng số nguyên và số nguyên k. Trả về k số có số lần xuất hiện nhiêu nhất
 */
public class TopKFrequentElement {

    public static int[] topKFrequent(int[] nums, int k) {
        // Count frequency
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        // Get unique number
        List<Integer> unique = new ArrayList<>(counter.keySet());
        // Sort by frequency (revered order)
        unique.sort((n1, n2) -> counter.get(n2) - counter.get(n1));

        // Create a min heap based on frequency
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(counter::get));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = unique.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
        assertArrayEquals(new int[]{1, 2}, topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

//	public static int[] topKFrequent(int[] A, int k) {
//		int n = A.length;
//		int[] mark = new int[n];
//		Arrays.fill(mark, 0);
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			int count = 1;
//			if (mark[i] == 0) {
//				for (int j = i + 1; j < n; j++) {
//					if (A[i] == A[j]) {
//						count++;
//						mark[j] = 1;
//					}
//				}
//				map.put(A[i], count);
//			}
//			mark[i] = 1;
//		}
//		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//		Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
//		int[] res = new int[k];
//		for (int i = 0; i < k; i++) {
//			res[i] = list.get(i).getKey();
//		}
//		return res;
//	}

}
