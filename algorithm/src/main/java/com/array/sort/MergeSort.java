package com.array.sort;

import java.util.Arrays;

public class MergeSort {

    // Merges two subarrays of arr[]
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = (mid + 1) - left;
        int n2 = right - mid;

        // Create temp arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays
        int i = 0, j = 0;
        int p = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[p++] = leftArray[i++];
            } else {
                arr[p++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[p++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[p++] = rightArray[j++];
        }
    }

    /**
     * Ta thấy:
     * - Mảng ban đầu được lặp lại hành động chia cho tới khi kích thước các mảng sau chia là 1.
     * - Khi kích thước các mảng con là 1, tiến trình gộp sẽ bắt đầu.
     * - Thực hiện gộp lại các mảng này cho tới khi hoàn thành và chỉ còn một mảng đã sắp xếp.
     */
    public static void mergerSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int m = left + (right - left) / 2;

            // Sort first and second halves
            mergerSort(arr, left, m);
            mergerSort(arr, m + 1, right);

            // Merge the sorted halves
            merge(arr, left, m, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 0, 1, 8, 6, 3, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        mergerSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
    }

    //    private static void merge(int[] arr, int left, int mid, int right) {
//        int[] temp = new int[right - left + 1]; // Create temp array with appropriate size
//
//        // Copy elements from arr to temp array
//        System.arraycopy(arr, left, temp, 0, temp.length);
//
//        int i = 0;
//        int j = mid + 1 - left;
//        int k = left;
//
//        while (i <= mid - left && j <= right - left) {
//            if (temp[i] <= temp[j]) {
//                arr[k++] = temp[i++];
//            } else {
//                arr[k++] = temp[j++];
//            }
//        }
//
//        // Copy remaining elements of temp[] if any
//        while (i <= mid - left) {
//            arr[k++] = temp[i++];
//        }
//    }

}
