package com.array;

import java.util.Arrays;

/*-
 * - Arrays.copyOfRange(arr, from, to) = arr[from...to-1]
 *
 * - Arrays.copyOf(arr, k) = Arrays.copyOfRange(arr, 0, k) = arr[0...k-1]
 *
 * - Chia một mảng thành 2 phần
 *
 *          int[] left  = Arrays.copyOfRange(arr, 0, k)          = arr[0...k-1]
 *          int[] right = Arrays.copyOfRange(arr, k, arr.length) = arr[k...n]
 */
public class SubArray {

    public static void main(String[] args) {
        int[] arr = {2, -1, 4, 0, 8, 7, 1};

        System.out.println("Length = " + arr.length);

        System.out.println();

        // Basic
        int from = 1, to = 5;
        int[] sub1 = Arrays.copyOfRange(arr, from, to);
        System.out.printf("arr[%s...%s] = %s%n", from, to - 1, Arrays.toString(sub1));

        System.out.println();

        // Nửa đầu và nửa cuối
        int k = 4;
        int[] left = Arrays.copyOfRange(arr, 0, k);
        int[] right = Arrays.copyOfRange(arr, k , arr.length);
        System.out.printf("arr[%s...%s] = %s%n", 0, k - 1, Arrays.toString(left));
        System.out.printf("arr[%s...%s] = %s%n", k, arr.length, Arrays.toString(right));

        System.out.println();

        // Copy k phần từ phần tử đầu tiên

        int[] sub2 = Arrays.copyOf(arr, k);
        int[] sub3 = Arrays.copyOfRange(arr, 0, k);
        System.out.printf("Copy %s phần tử đầu tiên: %s%n", k, Arrays.toString(sub2));
        System.out.printf("Copy %s phần tử đầu tiên: %s%n", k, Arrays.toString(sub3));
    }

}
