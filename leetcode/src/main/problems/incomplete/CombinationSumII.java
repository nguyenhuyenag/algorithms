package incomplete;

import java.util.*;

/*
    https://leetcode.com/problems/combination-sum-ii/

    Cho mảng số nguyên và số nguyên k. Tìm tất cả các mảng con (không lặp) có tổng bằng k.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int size = arr.length;
        int allMasks = 1 << size; // 2^size subsets
        for (int bit = 0; bit < allMasks; bit++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((bit & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }
            if (subset.stream().mapToInt(Integer::intValue).sum() == target) {
                Collections.sort(subset);
                result.add(subset);
            }
        }
        return new ArrayList<>(result);
    }

}
