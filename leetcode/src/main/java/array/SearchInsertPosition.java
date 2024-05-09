package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Cho mảng tăng dần, trả về vị trị nếu có của key trong mảng nếu có.
 * Nếu không có thì trả về vị trí mà nó sẽ được chèn vào (để mảng vẫn tăng dần)
 */
public class SearchInsertPosition {

    public int binarySearch(int[] nums, int key) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // = (l + r) / 2 nếu l, r quá lớn sẽ tràn số
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int idx = binarySearch(nums, target);
        if (idx != -1) {
            return idx;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void test() {
        // assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

}
