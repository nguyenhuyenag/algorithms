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
     * Duyệt qua các phần tử của mảng từ left + 1 đến right, tìm các
     * phần tử nhỏ hơn hoặc bằng pivot để đặt vào bên trái pivot và các
     * phần tử lớn hơn pivot để đặt vào bên phải pivot.
     */
    private static int partitionRight(int[] arr, int left, int right) {
        int pivot = arr[right]; // Choose the last element as the pivot
        int i = left;
        for (int j = left; j < right; j++) {
            // Nếu có phần tử < chốt thì đổi chỗ với phần tử đầu tiên và tăng con trỏ lên
            if (arr[j] < pivot) {
                swap(arr, i, j);
                System.out.println("pivot = " + pivot + ": " + Arrays.toString(arr));
                i++;
            }
        }
        /*
          - Sau thao tác swap() này, phần tử tại chỉ số i sẽ là phần tử chốt,
          các số bên trái sẽ nhỏ hơn chốt và các số bên phải sẽ lớn hơn chốt.
          - Thao tác hoán đổi này rất quan trọng nó đảm bảo rằng phần tử chốt
          được đặt ở vị trí đúng đắn liên quan đến các phần tử khác trong mảng.
         */
        swap(arr, i, right);
        return i; // Trả về chỉ mục của phần tử chốt
    }

    private static int partitionLeft(int[] arr, int left, int right) {
        int pivot = arr[left]; // Chọn phần tử đầu làm chốt
        int i = left;
        // arr[left] là pivot nên duyệt từ left + 1 -> cuối mảng
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

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // int pi = partitionLeft(arr, left, right);
            int pi = partitionRight(arr, left, right);

            // pi là chốt nên sẽ bỏ qua
            quickSort(arr, left, pi - 1); // Đệ quy trái
            quickSort(arr, pi + 1, right); // Đệ quy phải
        }
    }

    public static void quickSort3(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[right];
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
                i++;
                j--;
            }
        }
        quickSort3(arr, left, j); // Pass j instead of i
        quickSort3(arr, i, right); // Pass i instead of j
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.randomArray();
        System.out.println("Array:" + Arrays.toString(arr));
        // quickSort(arr, 0, arr.length - 1);
        quickSort3(arr, 0, arr.length - 1);
        System.out.println("Done: " + Arrays.toString(arr));
    }

}
