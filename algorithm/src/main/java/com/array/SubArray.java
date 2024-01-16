package com.array;

import java.util.Arrays;

/**
 * - copyOfRange(arr, fromIndex, toIndex)
 *
 * - copyOfRange(arr, endIndex) = copyOfRange(arr, 0, endIndex)
 */
public class SubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int startIndex = 2, endIndex = 6;
        int[] subArray = Arrays.copyOfRange(arr, startIndex, endIndex);

        // Copy n phần từ phần tử đầu tiên
        int[] subArray2 = Arrays.copyOf(arr, endIndex);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("SubArray_1: " + Arrays.toString(subArray));
        System.out.println("SubArray_2: " + Arrays.toString(subArray2));
    }

}
