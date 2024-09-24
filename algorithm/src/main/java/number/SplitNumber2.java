package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/combination-sum-iv/
 */
public class SplitNumber2 {

    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // Find all combinations
        findCombinations(nums, target, new ArrayList<>(), results);
        return results.size();
    }

    public static void findCombinations(int[] nums, int target,
                                        List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (target >= num) {
                current.add(num); // Choose the number
                findCombinations(nums, target - num, current, results); // Recur with reduced target
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    @Test
    public void test() {
        assertEquals(7, combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
