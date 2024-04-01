package com.array.sort;

import java.util.Arrays;

import static com.array.sort.SortUtils.*;
import static com.util.RandomUtils.*;

/**
 * Nếu số liền kề chưa đúng vị trí thì đổi chỗ
 */
public class BubbleSort {

    /**
     * Sắp xếp từ trái sang (từ trên xuống): Giả sử dãy cần sắp xếp có n phần tử.
     * - So sánh a0 và a1, nếu a0 > a1 thì đổi chỗ.
     * - Tiếp tục làm như vậy với các cặp (a1, a2), (a2, a3),...,(a_{n-1}, an).
     * - Sau bước này phần tử cuối cùng chính là phần tử lớn nhất của dãy.
     * - Sau đó, quay lại so sánh (và đổi chỗ nếu cần) 2 phần tử đầu cho đến khi gặp phần tử thứ n - 2....
     * Lưu ý: Nếu trong một lần duyệt, không phải đổi chỗ bất cứ cặp phần tử nào thì danh sách đã được sắp xếp xong
     */
    public static void bubbleSortLeftToRight() {
        int[] arr = randomArrays();
        int len = arr.length - 1;
        System.out.println("Array = " + Arrays.toString(arr) + ", length = " + arr.length);
        for (int i = 0; i < len; i++) {
            System.out.printf("i = %s%n", i);
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    System.out.printf("a%s <-> a%s: %s%n", j, j + 1, Arrays.toString(arr));
                }
            }
        }
        System.out.println("Done: " + Arrays.toString(arr));
    }

    public static void bubbleSort2() {
        int[] arr = randomArrays();
        int n = arr.length;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Length = " + n);
        // Vòng lặp ngoài, duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {
            System.out.println("i = " + i);
            // Vòng lặp trong, duyệt qua các phần tử từ arr[i+1] đến arr[n-1]
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    System.out.println(Arrays.toString(arr));
                }
            }
            // System.out.printf("Sorted: %s%n", Arrays.toString(arr));
        }
    }

    /**
     * Có thể được tối ưu hóa bằng cách dừng thuật toán nếu vòng lặp bên trong
     * mà không gây ra bất kỳ sự hoán đổi nào
     */
    public static void bubbleSort3() {
        int[] arr = randomArrays();
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // Nếu không có phần tử nào để hoán đổ bên trong vòng lặp thì break
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        bubbleSortLeftToRight();
        // bubbleSort2();
        // bubbleSort3();
    }
}
