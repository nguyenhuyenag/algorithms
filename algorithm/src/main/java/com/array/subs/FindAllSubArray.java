package com.array.subs;

import java.util.Arrays;

/**
 * Tìm tất cả các sub-array
 */
public class FindAllSubArray {

    // Recursive function to print all possible subarrays for given array
    public static void printSubArrays(int[] arr, int start, int end) {
        if (end == arr.length) {
            return; // Base case: Reached end of array
        } else if (start > end) {
            printSubArrays(arr, 0, end + 1);
        } else {
            // for (int i = start; i < end; i++)
            int[] sub = Arrays.copyOfRange(arr, start, end + 1);
            System.out.println(Arrays.toString(sub));
            printSubArrays(arr, start + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubArrays(arr, 0, 0);
    }

}
