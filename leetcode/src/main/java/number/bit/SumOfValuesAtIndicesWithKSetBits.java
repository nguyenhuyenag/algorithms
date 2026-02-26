package number.bit;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/

    Cho mảng số nguyên nums và một số nguyên k. Tính tổng các phần tử mà số bit
    trong biểu diễn nhị phân của chỉ số bằng k.

    Ví dụ: arr = [5, 10, 1, 5, 2], k = 1
        index = 0 -> bitCount(0) = 0
                1 -> bitCount(1) = 1    -> arr[1] = 10  -> ok
                2 -> bitCount(2) = 1    -> arr[2] = 1   -> ok
                3 -> bitCount(3) = 2
                4 -> bitCount(4) = 1    -> arr[4] = 2   -> ok
        => sum = 10 + 1 + 2 = 13
 */
public class SumOfValuesAtIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int bitCount = Integer.bitCount(i);
            // System.out.println(i + ", " + bitCount);
            if (bitCount == k) {
                // System.out.println(nums.get(i));
                sum += nums.get(i);
            }
        }
        return sum;
    }

    @Test
    public void test1() {
        assertEquals(13, sumIndicesWithKSetBits(List.of(5, 10, 1, 5, 2), 1));
    }

    @Test
    public void test2() {
        assertEquals(1, sumIndicesWithKSetBits(List.of(4, 3, 2, 1, 2), 2));
    }

}
