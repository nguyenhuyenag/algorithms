package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {

    public int[] sortArrayByParity2(int[] nums) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[j++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                ans[j++] = nums[i];
            }
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            // Find the first odd element from the left
            while (l < n && nums[l] % 2 == 0) {
                l++;
            }

            // Find the first even element from the right
            while (r >= 0 && nums[r] % 2 != 0) {
                r--;
            }

            // Swap the odd and even elements
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        return nums;
    }

    @Test
    public void doTest() {
        assertArrayEquals(new int[]{3, 1, 2, 4}, sortArrayByParity(new int[]{3, 1, 2, 4}));
    }

}
