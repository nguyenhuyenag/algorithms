package com.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getIntFrom(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

//    public static int getInt() {
//        return getIntFrom(-99, 99);
//    }

    public static int[] randomArrays(int length, int minValue, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = getIntFrom(minValue, maxValue);
        }
        // System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

    public static int[] randomArrays(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getIntFrom(-20, 20);
        }
        System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

    public static int[] randomArrays() {
        int n = getIntFrom(4, 9);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = getIntFrom(0, 9);
        }
        // System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        randomArrays(5);
    }

}
