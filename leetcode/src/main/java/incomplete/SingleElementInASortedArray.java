package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/single-element-in-a-sorted-array/

    Cho mảng đã sắp xếp, có duy nhất một phần tử xuất hiện 1 lần, các phần tử còn
    lại xuất hiện 2 lần. Tìm phần tử duy nhất đó.

    Your solution must run in O(log(n)) time and O(1) space.
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = r + (l - r) / 2;
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            // if (nums[mid] < nums[mid])
            l++;
            r--;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

}
