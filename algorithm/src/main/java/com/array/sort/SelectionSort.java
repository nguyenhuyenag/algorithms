package com.array.sort;

import java.util.Arrays;

import static com.array.sort.SortUtils.*;

/*-
 * Ý tưởng của thuật toán là tìm:
 *    Phần tử nhỏ nhất -> gán vào vị trí 0
 *    Phần tử nhỏ nhì -> gán vào vị trí 1
 */
public class SelectionSort {

    public static void selectionSort() {
        int[] arr = {9, 0, -1, 8, 6, 3, 1};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp [i, n]
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // Đổi chỗ phần tử nhỏ nhất, với phần tử đầu của đoạn [i, n]
            swap(arr, i, minIndex);
            System.out.println("Sorted: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        selectionSort();
    }

}
