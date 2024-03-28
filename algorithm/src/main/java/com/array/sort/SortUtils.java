package com.array.sort;

public class SortUtils {

    /**
     * Đổi chỗ 2 vị trí trong mảng
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
