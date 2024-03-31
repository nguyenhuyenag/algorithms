package com;

import com.array.sort.SortUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.array.sort.SortUtils.*;

public class AlgMain {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    System.out.println("Sorted: " + Arrays.toString(arr));
                }
            }
        }
    }

    // Dời các phần tử > key lên phía trước và chèn key vào vị trí trống
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // Mảng 1 phần tử luôn là mảng đã được sắp xếp
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Save current value
            int j = i - 1;
            // Dời các phần tử > key lên
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Chèn key vào chỗ trống
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Tìm số nhỏ nhất -> chèn vào vị trí 0, số nhỏ nhì -> chèn vào vị trí 1,...
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Giả sử vị trí hiện tại là số nhỏ nhất
            // Tìm số nhỏ nhất trong đoạn [i + 1,...,n]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Đã tìm được số nhỏ nhất
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 0, 1, 8, 6, 3, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        // bubbleSort(arr);
        // insertionSort(arr);
        selectionSort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

}
