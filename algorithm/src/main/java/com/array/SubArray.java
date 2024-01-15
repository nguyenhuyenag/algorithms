package com.array;

import java.util.Arrays;

public class SubArray {

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int startIndex = 2, endIndex = 6;

        int[] subArray = Arrays.copyOfRange(originalArray, startIndex, endIndex);

        // Copy n phần từ tính từ phần tử đầu tiên
        int[] subArray2 = Arrays.copyOf(originalArray, startIndex);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Subarray 1: " + Arrays.toString(subArray));
        System.out.println("Subarray 2: " + Arrays.toString(subArray2));
    }

}
