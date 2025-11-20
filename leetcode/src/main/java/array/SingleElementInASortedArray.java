package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/single-element-in-a-sorted-array/

    Cho mảng đã sắp xếp, có duy nhất một phần tử xuất hiện 1 lần, các phần tử còn
    lại xuất hiện 2 lần. Tìm phần tử duy nhất đó.

    Your solution must run in O(log(n)) time and O(1) space.
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Nếu chỉ có 1 phần tử thì là chính nó
        if (n == 1) return nums[0];

        // Tìm trong khoảng [1, n-1]
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        // Nếu không nằm ở giữa thì chắc chắn ở đầu hoặc cuối
        return nums[0] == nums[1] ? nums[n - 1] : nums[0];
    }

    @Test
    public void test() {
        assertEquals(2, singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        assertEquals(1, singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
        assertEquals(1, singleNonDuplicate(new int[]{1}));
    }

}
