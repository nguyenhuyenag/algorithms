package incomplete;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/combination-sum-iv/

    Cho một mảng các số nguyên phân biệt nums và một số nguyên mục tiêu target,
    hãy trả về số lượng các tổ hợp có thể sao cho tổng của chúng bằng target.

    Các bộ test được tạo ra sao cho kết quả có thể vừa trong một số nguyên 32-bit.
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        Stack<Integer> results = new Stack<>();
        // Find all combinations
        findCombinations(nums, target, new ArrayList<>(), results);
        return results.isEmpty() ? 0 : results.pop();
    }

    public static void findCombinations(int[] nums, int target,
                                        List<Integer> current, Stack<Integer> results) {
        if (target == 0) {
            if (results.isEmpty()) {
                results.push(1);
            } else {
                results.push(results.pop() + 1);
            }
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
