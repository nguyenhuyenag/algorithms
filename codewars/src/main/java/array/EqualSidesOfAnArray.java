package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5679aa472b8f57fb8c000047/
 *
 * Cho mảng số nguyên, tìm vị trí mà tổng bên trái và bên phải
 * bằng nhau. Trả về -1 nếu không có
 */
public class EqualSidesOfAnArray {

    public int findEvenIndex_0(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            int[] before = Arrays.copyOfRange(arr, 0, i);
            // int[] after = Arrays.copyOfRange(arr, i + 1, arr.length);
            int leftSum = Arrays.stream(before).sum();
            int rightSum = sum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int findEvenIndex_1(int[] arr) {
        int leftSum = 0;
        int totalSum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static int findEvenIndex(int[] arr) {
        int left = 0;
        int right = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            right -= arr[i];
            if (left == right) {
                return i;
            }
            left += arr[i];
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3, findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }

}
