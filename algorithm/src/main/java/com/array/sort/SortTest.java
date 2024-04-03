package com.array.sort;


import com.util.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.array.sort.BubbleSort.*;
import static com.array.sort.InsertionSort.*;
import static com.array.sort.QuickSort.*;
import static com.array.sort.QuickSort2.*;
import static com.array.sort.SelectionSort.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortTest {

    private int[] copyAndSort(int[] arr) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void test() {
        int numberOfTest = 14;
        for (int i = 0; i < numberOfTest; i++) {
            int[] arr = RandomUtils.randomArrays(7, 0, 10);
            int[] result = copyAndSort(arr);

            // bubbleSortLeftToRight(arr);
            // bubbleSortRightToLeft(arr);
            // selectionSort(arr);
            // insertionSort(arr);

            //quickSort(arr, 0, arr.length - 1);
            quickSort2(arr, 0, arr.length - 1);

            assertArrayEquals(result, arr);
        }
    }

}
