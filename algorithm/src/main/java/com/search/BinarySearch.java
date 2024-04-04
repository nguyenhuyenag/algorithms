package com.search;

import java.util.Arrays;

public class BinarySearch {

    // Array in ascending order
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                System.out.println("Index of key: ");
                return mid;
            }
            if (arr[mid] < key) {
                left = mid + 1; // Nếu mid < key, bỏ qua nửa bên trái
            } else {
                right = mid - 1; // Nếu mid >= key, bỏ qua nửa phải
            }
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        int key = 11;
        int[] A = {1, -9, 6, 11, 21, 6, 7, 90, 9, 1};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(binarySearch(A, key));
    }

}
