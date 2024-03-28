package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 *
 * Cho một mảng số nguyên thành k phần, mỗi phần thay thế các phần tử thành phần tử lớn nhất.
 * Tìm tổng lớn nhất của mảng sau khi thực hiện thao tác trên.
 *
 * arr = [1,15,7,9,2,5,10], k = 3 -> [15,15,15,  9,  10,10,10] = 84
 */
public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        return 1;
    }

    @Test
    public void test() {
        assertEquals(84, maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
