package com.array.sort;

import java.util.Arrays;

import static com.array.sort.SortUtils.*;

/*-
 * Ý tưởng của thuật toán là tìm:
 *    Phần tử nhỏ nhất -> gán vào vị trí 0
 *    Phần tử nhỏ nhì -> gán vào vị trí 1
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) { // i dừng ở n - 1 vì j bắt đầu ở i + 1
            // Tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp [i, n]
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Tìm được phần tử nhỏ nhất thì đổi chỗ nó với phần tử đầu tiên của đoạn
            swap(arr, i, minIndex);
            System.out.printf("Min = %s -> %s%n", arr[i], Arrays.toString(arr));
        }
        System.out.println("Done: " + Arrays.toString(arr));
    }

//    public static void main(String[] args) {
//        selectionSort();
//    }

}
