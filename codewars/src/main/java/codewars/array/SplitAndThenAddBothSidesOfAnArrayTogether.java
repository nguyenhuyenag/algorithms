package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/5946a0a64a2c5b596500019a/
 *
 * Chia 1 mảng thành 2 phần
 */
public class SplitAndThenAddBothSidesOfAnArrayTogether {

    /*-
     * Cộng 2 mảng không bằng nhau từ phải qua trái
     *          [1, 2, 2, 7]
     *       [2, 3, 5, 3, 1]
     *   -------------------
     *       [2, 4, 7, 5, 8]
     */
    public static int[] addFromRight(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int max = Math.max(len1, len2);
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            int num1 = (i < len1) ? arr1[(len1 - 1) - i] : 0;
            int num2 = (i < len2) ? arr2[(len2 - 1) - i] : 0;
            result[max - 1 - i] = num1 + num2;
        }
        return result;
    }

    /**
     * Chia mảng thành 2 phần và cộng 2 mảng từ phải qua trái
     */
    public static int[] splitAndAddHalf(int[] arr) {
        int len = arr.length;
        int mid = len / 2;
        int[] sub1 = Arrays.copyOfRange(arr, 0, mid);
        int[] sub2 = Arrays.copyOfRange(arr, mid, len);
        return addFromRight(sub1, sub2);
    }


    public static int[] splitAndAdd(int[] numbers, int n) {
        for (int i = 0; i < n; i++) {
            numbers = splitAndAddHalf(numbers);
        }
        return numbers;
    }

    @Test
    public void splitAndAdd() throws Exception {

        int[] expected = new int[]{5, 10};
        int[] input = splitAndAdd(new int[]{1, 2, 3, 4, 5}, 2);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{15};
        input = splitAndAdd(new int[]{1, 2, 3, 4, 5}, 3);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{15};
        input = splitAndAdd(new int[]{15}, 3);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{183, 125};
        input = splitAndAdd(new int[]{32, 45, 43, 23, 54, 23, 54, 34}, 2);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{32, 45, 43, 23, 54, 23, 54, 34};
        input = splitAndAdd(new int[]{32, 45, 43, 23, 54, 23, 54, 34}, 0);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{305, 1195};
        input = splitAndAdd(new int[]{3, 234, 25, 345, 45, 34, 234, 235, 345}, 3);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{1040, 7712};
        input = splitAndAdd(new int[]{3, 234, 25, 345, 45, 34, 234, 235, 345, 34, 534, 45, 645, 645, 645, 4656, 45, 3}, 4);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

        expected = new int[]{79327};
        input = splitAndAdd(new int[]{23, 345, 345, 345, 34536, 567, 568, 6, 34536, 54, 7546, 456}, 20);

        assertEquals(Arrays.toString(expected), Arrays.toString(input));

    }

//    @Test
//    public void test() {
////        int[] arr = {1, 2, 5, 7, 2, 3, 5, 7, 8};
////        int len = arr.length;
////        int mid = len / 2;
////        int[] sub1 = Arrays.copyOfRange(arr, 0, mid);
////        int[] sub2 = Arrays.copyOfRange(arr, mid, len);
////        System.out.println(Arrays.toString(sub1));
////        System.out.println(Arrays.toString(sub2));
//    }

}
