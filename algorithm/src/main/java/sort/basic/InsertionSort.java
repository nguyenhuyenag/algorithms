package sort.basic;

import util.RandomUtils;

import java.util.Arrays;

/*-
    - Mảng 1 phần tử luôn là mảng đã được sắp xếp.

    - Từ phần tử thứ 2 trở đi (index >= 1), lưu giá trị của phần tử hiện tại (key) và duyệt ngược
    mảng trước nó. Nếu có phần từ lớn hơn key thì dời phần tử đó lên, dừng nếu gặp phần tử nhỏ hơn.

    - Chèn key vào vị trí trống (sau phần tử nhỏ nhất).

    - Ví dụ:

        i = 0:  [0, 1, 9, 8, 6, 3, 1]
        i = 1:  [0, 1, 9, 8, 6, 3, 1]
        i = 2:  [0, 1, 9, 8, 6, 3, 1]

        i = 3:  [0, 1, 9, _, 6, 3, 1],  key = 8
                [0, 1, _, 9, 6, 3, 1],  move 9 to right
                [0, 1, 8, 9, 6, 3, 1],  insert 8

        i = 4:  [0, 1, 8, 9, _, 3, 1],  key = 6
                [0, 1, _, 8, 9, 3, 1],  move 8, 9 to right
                [0, 1, 6, 8, 9, 3, 1],  insert 6

        i = 5:  [0, 1, 6, 8, 9, _, 1],  key = 3
                [0, 1, _, 6, 8, 9, 1],  move 6, 8, 9 to right
                [0, 1, 3, 6, 8, 9, 1],  insert 3

        i = 6:  [0, 1, 3, 6, 8, 9, _],  key = 1
                [0, 1, 1, 3, 6, 8, 9],  move 3, 6, 8, 9 to right
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lưu giá trí phần tử cần chèn
            int j = i - 1;
            // Dời các phần tử > key lên phía trước
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                System.out.printf("Move: %s%n", Arrays.toString(arr));
                j--;
            }
            // Gán key vào vị trí trống
            arr[j + 1] = key;
            System.out.printf("Sorted: %s%n", Arrays.toString(arr));
        }
        System.out.println("Done: " + Arrays.toString(arr));
    }

    public static void insertionSort2() {
        int[] arr = {9, 0, 1, 8, 6, 3, 1};
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lưu giá trí phần tử cần chèn
            int j; //  = i - 1;
            // Dời các phần tử
            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            // Gán key vào vị trí trống
            arr[j + 1] = key;
            System.out.printf("Sorted: %s%n", Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 9, 8, 6, 3, 1};
        insertionSort(arr);
        // insertionSort2();
    }

}
