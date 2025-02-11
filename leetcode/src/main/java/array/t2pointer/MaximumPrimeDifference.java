package array.t2pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/maximum-prime-difference/

    Cho mảng số nguyên A. Giả sử Ai, Aj là thứ tự của 2 số nguyên tố. Tìm giá trị lớn nhất của |Ai - Aj|.

    Ví dụ: nums = [4, 2, 9, 5, 3] -> Kết quả là 3.

        => Vì A1, A3, và A4 là số nguyên tố. Nên kết quả là |4 - 1| = 3 là giá trị lớn nhất cần tìm.
 */
public class MaximumPrimeDifference {

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            boolean leftCheck = isPrime(nums[l]);
            // Tìm được cả 2 vị trí cùng là SNT
            if (leftCheck && isPrime(nums[r])) {
                return r - l;
            } else if (!leftCheck) { // Số bên trái không phải SNT -> tăng l
                l++;
            } else { // Số bên phải không phải STN -> giảm r
                r--;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(3, maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        assertEquals(0, maximumPrimeDifference(new int[]{4, 8, 2, 8}));
    }

//    public int maximumPrimeDifference_OK(int[] nums) {
//        int n = nums.length;
//        boolean[] mark = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            if (primeCheck(nums[i])) {
//                mark[i] = true;
//            }
//        }
//        int l = 0, r = n - 1;
//        while (l <= r) {
//            if (mark[l] && mark[r]) {
//                return Math.abs(l - r);
//            } else if (mark[l] == false) {
//                l++;
//            } else {
//                r--;
//            }
//        }
//        return 0;
//    }

}
