package com.sort.basic;

import static com.sort.basic.SortUtils.*;

public class QuickSort2 {

    public static int partitionMid(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];
        // Tiến hành phân chia mảng
        int i = left, j = right;
        while (i <= j) {
            // Nếu các giá trị bên trái vẫn < pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Nếu các giá trị bên phải vẫn > pivot
            while (arr[j] > pivot) {
                j--;
            }
            // So sánh giá trị từ cả hai phía xem có cần đổi chỗ hay không
            if (i <= j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return i;
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int index = partitionMid(arr, left, right);
        if (left < index - 1) {
            quickSort2(arr, left, index - 1);
        }
        if (index < right) {
            quickSort2(arr, index, right);
        }
    }

}
