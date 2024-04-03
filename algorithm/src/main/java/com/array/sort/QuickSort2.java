package com.array.sort;

public class QuickSort2 {

    public static int partition(int arr[], int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];
        // Tiến hành phân chia mảng
        int i = left, j = right;
        while (i <= j) {
            // Kiểm tra cho đến khi tất cả giá trị trong mảng bên trái nhỏ hơn pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Kiểm tra cho đến khi tất cả các giá trị trong mảng bên phải lớn hơn pivot
            while (arr[j] > pivot) {
                j--;
            }
            // So sánh giá trị từ cả hai phía xem có cần đổi chỗ hay không
            if (i <= j) {
                SortUtils.swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort2(arr, left, index - 1);
        }
        if (index < right) {
            quickSort2(arr, index, right);
        }
    }

    public static void main(String[] args) {

    }

}
