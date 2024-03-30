package com.array.sort;

import java.util.Arrays;

import static com.array.sort.SortUtils.*;

/**
 * Nếu số liền kề nhỏ hơn thì đổi chỗ
 */
public class BubbleSort {

    public static void bubbleSort2() {
        int[] arr = {9, 0, 1, 8, 6, 3, 1};
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.printf("Min = %s -> %s%n", arr[i], Arrays.toString(arr));
        }
    }

    public static void bubbleSort1() {
        int[] arr = {9, 0, 1, 8, 6, 3, 1};
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        // Vòng lặp ngoài, duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {
            // Vòng lặp trong, duyệt qua các phần tử từ arr[i+1] đến arr[n-1]
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
            System.out.printf("Sorted: %s%n", Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        bubbleSort1();
        // bubbleSort2();
    }
}
