package sort.basic;


import util.RandomUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    https://leetcode.com/problems/sort-colors/

    https://leetcode.com/problems/sort-an-array/
 */
public class SortTest {

    @Test
    public void test() {
        int numberOfTest = 1;
        for (int i = 0; i < numberOfTest; i++) {
            int[] arr = RandomUtils.randomArray(7, 0, 10);
            int[] result = SortUtils.copyAndSort(arr);

            // bubbleSortLeftToRight(arr);
            // bubbleSortRightToLeft(arr);
            // selectionSort(arr);
            // insertionSort(arr);

            // quickSort(arr, 0, arr.length - 1);
            // quickSort2(arr, 0, arr.length - 1);
            QuickSort.quickSort3(arr, 0, arr.length - 1);

            assertArrayEquals(result, arr);
        }
    }

}
