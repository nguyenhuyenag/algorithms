package leetcode;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * Cho mảng đã sắp xếp, tìm k số gần x nhất
 */
public class MainLeet {

    // Function to generate all subsets of an array with a specified size using bitwise operations
    public static void generateSubsets(int[] arr, int k) {
        int n = arr.length;
        // Total number of subsets is 2^n
        int totalSubsets = 1 << n;
        // Iterate through all possible subsets
        for (int i = 0; i < totalSubsets; i++) {
            // Count the number of set bits in the current subset bitmask
            int count = Integer.bitCount(i);
            // Check if the count matches the specified size
            if (count == k) {
                System.out.print("Subset " + (i + 1) + ": {");
                // Include elements in the subset
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(arr[j] + " ");
                    }
                }
                System.out.println("}");
            }
        }
    }


    @Test
    public void test() {
        // assertEquals(3, triangleNumber(new int[]{2, 2, 3, 4}));
        // assertEquals(4, triangleNumber(new int[]{4, 2, 3, 4}));
        // assertEquals(75781, triangleNumber(new int[]{16, 70, 16, 36, 17, 39, 44, 72, 25, 88, 18, 22, 20, 84, 18, 66, 71, 74, 87, 59, 48, 91, 52, 15, 92, 29, 85, 21, 10, 34, 86, 68, 10, 27, 3, 42, 49, 48, 18, 15, 6, 39, 61, 28, 19, 52, 60, 8, 37, 32, 71, 82, 54, 38, 47, 33, 10, 64, 52, 71, 39, 63, 64, 79, 86, 47, 16, 72, 55, 17, 35, 88, 74, 93, 10, 59, 3, 64, 95, 91, 61, 28, 63, 23, 49, 6, 24, 47, 41, 88, 96, 23, 90, 53, 84, 3, 35, 23, 3, 17}));
        int k = 3;
        int[] arr = {16, 70, 16, 36, 17, 39, 44, 72, 25, 88, 18, 22, 20, 84, 18, 66};
        generateSubsets(arr, k);
    }

}
