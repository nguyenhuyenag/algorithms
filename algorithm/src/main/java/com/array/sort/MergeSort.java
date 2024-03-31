package com.array.sort;

import java.util.Arrays;

public class MergeSort {

    // Merges two subarrays of arr[]
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
//    public static void merge(int arr[], int left, int mid, int right) {
//        // Find sizes of two subarrays to be merged
//        int n1 = mid - left + 1;
//        int n2 = right - mid;
//
//        // Create temp arrays
//        int L[] = new int[n1];
//        int R[] = new int[n2];
//
//        // Copy data to temp arrays
//        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
//        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];
//
//        // Merge the temp arrays
//
//        // Initial indices of first and second subarrays
//        int i = 0, j = 0;
//
//        // Initial index of merged subarray array
//        int k = left;
//        while (i < n1 && j < n2) {
//            if (L[i] <= R[j]) {
//                arr[k] = L[i];
//                i++;
//            } else {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
//
//        // Copy remaining elements of L[] if any
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        // Copy remaining elements of R[] if any
//        while (j < n2) {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

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
}
