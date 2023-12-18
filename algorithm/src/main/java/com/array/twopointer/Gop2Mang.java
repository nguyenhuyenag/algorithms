package com.array.twopointer;

import java.util.Arrays;

/**
 * Gộp 2 mảng tăng dần
 */
public class Gop2Mang {

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 8, 10};
        int[] b = {2, 6, 7, 12, 14, 15};
        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i++];
                // i++;
            } else { // a[i] >= b[j]
                c[k] = b[j++];
                // j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của dãy a (nếu có)
        while (i < a.length) {
            c[k] = a[i++];
            // i++;
            k++;
        }

        // Sao chép các phần tử còn lại của dãy b (nếu có)
        while (j < b.length) {
            c[k] = b[j++];
            // j++;
            k++;
        }

        System.out.println(Arrays.toString(c));
    }

}
