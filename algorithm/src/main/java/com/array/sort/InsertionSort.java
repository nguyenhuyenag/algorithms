package com.array.sort;

import java.util.Arrays;

/*-
 * - Mảng 1 phần tử luôn là mảng đã được sắp xếp
 * - Từ phần tử thứ 2 trở đi (index >= 1), lưu giá trị của phần tử hiện tại (key) và duyệt ngược
 *   mảng trước nó. Nếu có phần từ lớn hơn key thì dời phần tử đó lên, dừng nếu gặp phần tử nhỏ hơn.
 * - Chèn key vào vị trí trống (sau phần tử nhỏ nhất).
 *
 * - Ví dụ: Với key = 8
 *
 *      [0, 1, 9, 8, 6, 3, 1] -> [0, 1, _, 9, 6, 3, 1] -> [0, 1, 8, 9, 6, 3, 1]
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // int[] arr = {9, 0, 1, 8, 6, 3, 1};
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lưu giá trí phần tử cần chèn
            int j = i - 1;
            // Dời các phần tử > key lên phía trước
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Gán key vào vị trí trống
            arr[j + 1] = key;
            System.out.printf("Sorted: %s%n", Arrays.toString(arr));
        }
        System.out.println("Done: " + Arrays.toString(arr));
    }

//    public static void insertionSort2() {
//        int[] arr = {9, 0, 1, 8, 6, 3, 1};
//        int n = arr.length;
//        System.out.println("Array: " + Arrays.toString(arr));
//        for (int i = 1; i < n; i++) {
//            int key = arr[i]; // Lưu giá trí phần tử cần chèn
//            int j; //  = i - 1;
//            // Dời các phần tử
//            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
//                arr[j + 1] = arr[j];
//            }
//            // Gán key vào vị trí trống
//            arr[j + 1] = key;
//            System.out.printf("Sorted: %s%n", Arrays.toString(arr));
//        }
//    }

//    public static void main(String[] args) {
//        insertionSort1();
//        // insertionSort2();
//    }

}
