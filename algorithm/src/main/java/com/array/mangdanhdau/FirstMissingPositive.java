//package com.array.mangdanhdau;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.stream.IntStream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Tìm số nguyên dương nhỏ nhất bị thiếu trong mảng
// * [1, 1, 0, -1, -2] 				-> 		2
// * [2, 3, 7, 6, 8, -1, -10, 15] 	-> 		1
// * [2, 3, -7, 6, 8, 1, -10, 15] 	-> 		4
// */
//public class FirstMissingPositive {
//
//    public static int firstMissingPositive(int[] arr) {
//        int n = arr.length;
//        boolean[] mark = new boolean[n + 2];
//
//        for (int x : arr) {
//            if (x <= 0 || x > n + 1) {
//                continue;
//            }
//            mark[x] = true;
//        }
//
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(IntStream.range(0, n + 2).toArray()));
//        System.out.println(Arrays.toString(mark));
//
//        /**
//         * Nếu phần tử mark[i] là false, tức là số i không xuất hiện trong mảng arr
//         */
//        for (int i = 1; i < mark.length; i++) {
//            if (!mark[i]) {
//                return i;
//            }
//        }
//
//        /**
//         * Nếu tất cả các số từ 1 đến n + 1 đều xuất hiện trong mảng arr, thì trả về 0
//         */
//        return 0;
//    }
//
//    @Test
//    public void doTest() {
//        // assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
//        // assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
//        // assertEquals(1, firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
//    }
//
//}
