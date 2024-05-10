package queue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/
 *
 * Cho mảng arr chứa các số nguyên tố duy nhất và số nguyên k. Tạo các phân số
 * arr[i] / arr[j] từ các phần tử trong mảng.
 *
 * Tìm số nhỏ nhất thứ k, kết quả trả về dạng mảng [arr[i], arr[j]]
 */
public class KthSmallerPrimeFaction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeMap<Double, int[]> treeMap = new TreeMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                treeMap.put((double) arr[i] / arr[j], new int[]{arr[i], arr[j]});
            }
        }
        while (k > 1) {
            treeMap.pollFirstEntry();
            k--;
        }
        return treeMap.firstEntry().getValue();
    }

    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 5};
        assertArrayEquals(new int[]{2, 5}, kthSmallestPrimeFraction(arr, 3));
    }

    @Test
    public void test2() {
        int[] arr = {1, 7};
        assertArrayEquals(new int[]{1, 7}, kthSmallestPrimeFraction(arr, 1));
    }

}
