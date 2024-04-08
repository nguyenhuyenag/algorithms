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

    @Test
    public void test() {
        int numberOfTest = 90;
        for (int i = 0; i < numberOfTest; i++) {
            int[] arr = RandomUtils.randomArray(7, 0, 10);
            int[] result = SortUtils.copyAndSort(arr);

            // bubbleSortLeftToRight(arr);
            // bubbleSortRightToLeft(arr);
            // selectionSort(arr);
            // insertionSort(arr);

            // quickSort(arr, 0, arr.length - 1);
            // quickSort2(arr, 0, arr.length - 1);
            quickSort3(arr, 0, arr.length - 1);

            assertArrayEquals(result, arr);
        }
    }

}
