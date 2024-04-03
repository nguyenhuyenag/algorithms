package com.array.sort;

import com.util.RandomUtils;

import java.util.Arrays;

import static com.array.sort.SortUtils.*;

/**
 * - Chọn ngẫu nhiên một phần tử làm khóa X
 * - Xếp các phần tử nhỏ phần tử chốt ở phía trước X
 * - Xếp các phần tử lớn hơn phần tử chốt ở phía sau X
 */
public class QuickSort {

    /**
     * duyệt qua các phần tử của mảng từ left + 1 đến right, tìm các
     * phần tử nhỏ hơn hoặc bằng pivot để đặt vào bên trái pivot và các
     * phần tử lớn hơn pivot để đặt vào bên phải pivot.
     */
    private static int partitionRight(int[] arr, int left, int right) {
        int pivot = arr[right]; // Chọn phần tử cuối cùng làm chốt
        int i = left - 1;
        // Pivot là arr[right] nên duyệt từ left -> right = arr.length - 1
        for (int j = left; j < right; j++) {
            // Nếu có phần tử < chốt
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1; // Trả về chỉ mục của phần tử chốt
    }

    private static int partitionLeft(int[] arr, int left, int right) {
        int pivot = arr[left]; // Chọn phần tử đầu làm chốt
        int i = left;
        // arr[left] là pivot nên duyệt từ [left + 1 -> right] ( = arr.length - 1)
        for (int j = left + 1; j <= right; j++) {
            // Nếu có phần tử < chốt
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i, left);
        return i; // Trả về chỉ mục của phần tử chốt
    }

    private static int partitionMid(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        // Move the pivot element to the end
        swap(arr, mid, right);

        int i = left - 1; // Initialize the index of the smaller element

        for (int j = left; j < right; j++) {
            // If the current element is smaller than the pivot
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element
                swap(arr, i, j);
            }
        }

        // Move the pivot element to its correct position
        swap(arr, i + 1, right);

        return i + 1;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Tìm chốt
            // int pi = partitionRight(arr, left, right);
            // int pi = partitionLeft(arr, left, right);

            int pi = partitionMid(arr, left, right);

            quickSort(arr, left, pi - 1); // Đệ quy trái
            quickSort(arr, pi + 1, right); // Đệ quy phải
            // pi là chốt nên sẽ bỏ qua
        }
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.randomArrays();
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}