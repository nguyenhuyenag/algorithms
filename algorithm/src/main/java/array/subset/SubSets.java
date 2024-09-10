package array.subset;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // backtrack(result, new ArrayList<>(), nums, 0);
        backtrack_contains_duplicates(result, new ArrayList<>(), nums, 0);
        return result;
    }

//    private void backtrack_0(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            backtrack_0(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    // Contains duplicates
    private void backtrack_contains_duplicates(List<List<Integer>> list,
                                               List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack_contains_duplicates(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        var subsets = subsets(nums);
        // @formatter:off
        var results = List.of(
            new ArrayList<>(),
            List.of(1),
            List.of(1,2),
            List.of(1,2,3),
            List.of(1,3),
            List.of(2),
            List.of(2,3),
            List.of(3)
        );
        // @formatter:on
        subsets.forEach(set -> System.out.println("set = " + Arrays.toString(set.toArray())));
        // Assertions.assertIterableEquals(results, subsets);
    }

}
