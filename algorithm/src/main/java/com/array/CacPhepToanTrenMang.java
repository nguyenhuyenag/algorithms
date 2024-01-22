package com.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * arraycopy(int[] src, int srcPos, int[] dest, int destPos, int length)
 *
 *      src        Mảng nguồn
 *      srcPos     Vị trí bắt đầu sao chép
 *      dest       Mảng đích
 *      destPos    Vị trí bắt đầu gán kết quả
 *      length     Số phần tử cần sao chép
 */
public class CacPhepToanTrenMang {

    /**
     * Gộp 2 mảng
     */
    public static void merge1(int[] arrayA, int[] arrayB) {
        int lenA = arrayA.length, lenB = arrayB.length;
        int[] ans = new int[lenA + lenB];
        System.arraycopy(arrayA, 0, ans, 0, lenA);
        System.arraycopy(arrayB, 0, ans, lenA, lenB);
        System.out.println("c = " + Arrays.toString(ans));
    }

    /**
     * Gộp 2 mảng
     */
    public int[] merge2(int[] A, int[] B) {
        int pointer = 0;
        int[] result = new int[A.length + B.length];
        for (int x : A) {
            result[pointer++] = x;
        }
        for (int x : B) {
            result[pointer++] = x;
        }
        return result;
    }

    /**
     * Giao 2 mảng (tìm phần tử chung)
     */
    public int[] intersect(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                result.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testIntersect() {
        // int[] arr = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] arr = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Test
    public void testMerge() {
        int[] A = {1, 2, 3, 4};
        int[] B = {5, 6, 7};
        int[] X = merge2(A, B);
        System.out.println("X = " + Arrays.toString(X));
        merge2(A, B);
    }

}