package com.array.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortUtils {

    /**
     * Đổi chỗ 2 vị trí trong mảng
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] copyAndSort(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);
        return copy;
    }

//    public static <T> void swap(T[] arr, int i, int j) {
//        T t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }

//    public static <T> void swap(List<T> list, int i, int j) {
//        Collections.<T>swap(list, i, j);
//    }

}
