package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/maximum-product-of-three-numbers/

    Tìm giá trị lớn nhất của tích 3 số trong mảng.
 */
public class MaximumProductOf3Numbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Case 1: Product of three largest numbers
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        // Case 2: Product of two smallest numbers and the largest number
        int product2 = nums[n - 1] * nums[0] * nums[1];
        // Return the maximum of the two products
        return Math.max(product1, product2);
    }

    @Test
    public void test() {
        assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
        assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
    }

}
