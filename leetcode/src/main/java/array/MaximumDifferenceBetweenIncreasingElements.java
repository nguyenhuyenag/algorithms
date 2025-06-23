package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/maximum-difference-between-increasing-elements/

    Cho mảng số nguyên dương arr, tìm giá trị lớn nhất của arr[j] - arr[i] với i < j.
    Nếu không có giá trị nào thỏa mãn thì trả về -1.
 */
public class MaximumDifferenceBetweenIncreasingElements {

    // Bad solution: O(n^2)
    public int maximumDifference_OK(int[] nums) {
        int maxDiff = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    maxDiff = Math.max(maxDiff, nums[j] - nums[i]);
                }
            }
        }
        return maxDiff;
    }

    public int maximumDifference(int[] nums) {
        int cmin = nums[0]; // Current min
        int maxDiff = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > cmin) {
                // So sánh độ lớn của |nums[i] - cmin| và giá trị maxDiff hiện tại
                maxDiff = Math.max(maxDiff, nums[i] - cmin);
            } else { // nums[i] <= cmin -> Cập nhật cmin
                cmin = nums[i];
            }
        }
        return maxDiff;
    }

    @Test
    public void test() {
        assertEquals(4, maximumDifference(new int[]{7, 1, 5, 4}));
        assertEquals(-1, maximumDifference(new int[]{9, 4, 3, 2}));
        assertEquals(9, maximumDifference(new int[]{1, 5, 2, 10}));
    }

}
