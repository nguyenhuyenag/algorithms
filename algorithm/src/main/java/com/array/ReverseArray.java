package com.array;

import java.util.Arrays;

/**
 * Xem thêm: Leetcode > RotateArray.java
 */
public class ReverseArray {

    // Đảo mảng dùng 2 con trỏ
    public static void reverse0(int[] nums, int start, int end) {
        while (start < end) {
            // Swap giá trị của nums[start] và nums[end]
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Di chuyển về phía giữa mảng
            start++;
            end--;
        }
    }

    // Đảo mảng dùng vòng for
    public static void reverse1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = tmp;
        }
    }

    // Dùng mảng phụ
//    public static int[] reverse1(int[] arr) {
//        int n = arr.length;
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = arr[n - 1 - i];
//        }
//        return result;
//    }

    // Không dùng mảng phụ
//    public static void reverseInPlaceUsingWhile(int[] arr) {
//        int i = 0;
//        int j = arr.length - 1;
//        while (i != j) {
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//            i++;
//            j--;
//        }
//    }

    // Dùng IntStream
//    public static int[] reverse2(int[] A) {
//        int n = A.length;
//        return IntStream.range(0, n).map(i -> A[n - 1 - i]).toArray();
//    }

    // Chỉ định vị tri cần xoay
//    public static int[] reverse3(int[] A) {
//        int from = 0, to = A.length;
//        return IntStream.range(from, to).map(i -> from - 1 + to - i).map(t -> A[t]).toArray();
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        reverse0(arr, 2, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
