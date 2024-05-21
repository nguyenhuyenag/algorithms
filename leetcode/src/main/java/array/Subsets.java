package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * <p>
 * Cho mảng chứa các số nguyên không trùng nhau. In ra các tập con của mảng (tập con cũng không chứa
 * các phần tử trùng) bao gồm cả tập rỗng.
 */
public class Subsets {

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
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
        // subsets.forEach(set -> System.out.println("set = " + Arrays.toString(set.toArray())));
        Assertions.assertIterableEquals(results, subsets);
    }

}
