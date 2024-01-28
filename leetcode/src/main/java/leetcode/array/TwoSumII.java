package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * Chủ đề: Two pointer
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Tìm 2 phần tử (i != j) có tổng bằng k trong mảng
 */
public class TwoSumII {

    public int[] twoSum0(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n2 = target - nums[i];
            // Nếu n2 có trong map -> lấy ra chỉ số
            if (map.containsKey(n2)) {
                int j = map.get(n2);
                return nums[i] >= nums[j] ? new int[]{j + 1, i + 1} : new int[]{i + 1, j + 1};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else { // sum > target
                r--;
            }
        }
        return new int[]{0, 0};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{0, 0, 3, 4}, 0));
    }

}
