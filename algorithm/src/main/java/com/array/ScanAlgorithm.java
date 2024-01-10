package com.array;

/**
 * Xem thêm: BestTimeToBuyAndSaleStock.java
 */
public class ScanAlgorithm {

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int convertToInt(String s) {
        int n = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            n = 10 * n + Character.getNumericValue(s.charAt(i));
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(convertToInt("123"));
    }

}
