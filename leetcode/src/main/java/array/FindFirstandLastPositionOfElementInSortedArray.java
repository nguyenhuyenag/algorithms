package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Cho mảng đã sắp xếp, trả về mảng chứa 2 vị trí mà giá trị ở đó bằng tới x
 * Nếu không tồn tại thì trả về [-1, -1]
 */
public class FindFirstandLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target && nums[r] == target) {
                return new int[]{l, r};
            } else if (nums[l] < target) {
                l++;
            } else if (nums[r] > target) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 4}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

}
