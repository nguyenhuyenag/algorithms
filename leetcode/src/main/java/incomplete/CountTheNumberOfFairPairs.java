package incomplete;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/count-the-number-of-fair-pairs/

    Cho mảng số nguyên nums và 2 số nguyên low, up. Tìm tất cả các cặp (i,j) thỏa mãn:

        (*)     0 <= i < j < n
        (**)    lower <= nums[i] + nums[j] <= upper

    Example 1:
        Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
        Output: 6
        Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 */
public class CountTheNumberOfFairPairs {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Map<Integer, Integer> mapLower = new HashMap<>();
        Map<Integer, Integer> mapUpper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

}
