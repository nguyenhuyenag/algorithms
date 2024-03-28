package com.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Chuyển k phần tử đầu tiên về cuối mảng
 *
 * Xem thêm: Leetcode > RotateArray.java
 */
public class RotateArray {

    /**
     * Dời 1 phần từ về cuối (xoay phải)
     */
    public static void moveMove(int[] arr) {
        int arr0 = arr[0]; // Lưu arr[0]
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1]; // Dời từng phần tử lên phía trước
        }
        arr[arr.length - 1] = arr0; // Gán phần tử cuối cùng là arr[0]
    }

    // Xoay phải k lần
    public static void rotate(int[] arr, int k) {
        for (int i = 1; i <= k; i++) {
            moveMove(arr);
        }
    }

    public static <T> void moveByCollection(T[] arr, int k) {
        List<T> list = Arrays.asList(arr);
        System.out.println("Before: " + Arrays.toString(arr));
        // k > 0 xoay trái (dời cuối lên đầu), k < 0 xoay phải (dời đầu xuống cuối)
        Collections.rotate(list, k);
        System.out.println("After: " + Arrays.toString(list.toArray()));
    }

    /**
     * Mối quan hệ của xoay phải và xoay trái
     */
    public static void testRotateLeftAndRight() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        int n = list2.size(); // Số lượng phần tử
        int k = 2; // Số lần xoay trái

        if (n <= k) k = k % n; // Đảm bảo k luôn nhỏ hơn n
        int rotate = n - k; // Số lần xoay phải tương

        Collections.rotate(list1, k);
        Collections.rotate(list2, -rotate); // số âm sẽ xoay phải

        System.out.println(list1);
        System.out.println(list2);
    }

    public static void main(String[] args) {
        testRotateLeftAndRight();
    }

}
