package com.array;

import java.util.Arrays;

public class DuyetMang {

    /**
     * Ở mỗi vị trí i, in ra các số từ 0 -> i - 1 và i + 1 -> end
     */
    public void findEvenIndex(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        // System.out.println(Arrays.toString(arr));
        // System.out.println();
        for (int i = 0; i < arr.length; i++) {
            int[] before = Arrays.copyOfRange(arr, 0, i);
            // int[] after = Arrays.copyOfRange(arr, i + 1, arr.length);
            // System.out.print(Arrays.toString(before) + ", " + Arrays.toString(after));
            // System.out.println();
            int leftSum = Arrays.stream(before).sum();
            // int rightSum = sum - leftSum - arr[i];
        }
    }

}
