package incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

    Cho mảng số nguyên, tìm tổng của các mảng con có độ dài lẻ.
 */
public class SumOfAllOddLengthSubarray {

//    public int sumOddLengthSubarrays(int[] arr) {
//        int sum = 0;
//        int n = arr.length;
//        for (int i = 0; i < arr.length; i++) {
//            int left = i + 1;
//            int right = n - i;
//            int k = left * right;
//            int odd = (k + 1) / 2;
//            sum = sum + odd * arr[i];
//        }
//        return sum;
//    }

    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += 2) { // j increments by 2 to ensure odd-length
                for (int k = i; k <= j; k++) {
                    totalSum += arr[k];
                }
            }
        }
        return totalSum;
    }

    @Test
    public void test() {
        assertEquals(58, sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        // assertEquals(66, sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

}
