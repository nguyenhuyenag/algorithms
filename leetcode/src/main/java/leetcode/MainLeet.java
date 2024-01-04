package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class MainLeet {

    // [1, 2, 3, 4, 5, 6, 7] -> [7, 1, 2, 3, 4, 5, 6]
    public static void oneStep0(int[] nums) {
        int len = nums.length;
        int lastItem = nums[len - 1];
        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = lastItem;
    }

    public int[] rotate0(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            oneStep0(nums);
        }
        return nums;
    }

    public int[] rotate(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        int len = nums.length;

        // Copy k số cuối cùng
        for (int i = len - k; i < len; i++) {
            result.add(nums[i]);
        }

        // Copy từ số đầu tiên đến k
        for (int i = 0; i < len - k; i++) {
            result.add(nums[i]);
        }

        // Gán lại giá trị cho nums
        for (int i = 0; i < len; i++) {
            nums[i] = result.get(i);
        }

        return nums;
    }

    @Test
    public void testSomething() {
        assertArrayEquals(new int[]{3, 99, -1, -100}, rotate(new int[]{-1, -100, 3, 99}, 2));
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
    }

}
