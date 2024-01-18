package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 */
public class MainLeet {

//    public static void main(String[] args) {
//        int k = 8;
//        int[] arr = {1, 2, 3, 5, 6};
//        subarraySum(arr, k);
//    }

    public void printSubarray(int[] arr, int start, int end, int k) {
        System.out.print("Subarray with sum " + k + ": ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int subarraySum(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == k) {
                    // printSubarray(arr, i, j, k);
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j + 1)));
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        // assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
    }

}
