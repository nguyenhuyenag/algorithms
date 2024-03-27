package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Tìm tất cả các mảng con liên tiếp có tích <= k
 */
public class SubarrayProductLessThanK {

    private int count = 0;

    public void findAllSubArray(int[] arr, int start, int end, int k) {
        if (end == arr.length) {
            return;
        } else if (start > end) {
            findAllSubArray(arr, 0, end + 1, k);
        } else { // start <= end
            int product = 1;
            for (int i = start; i <= end; i++) {
                product *= arr[i];
            }
            if (product < k) {
                count++;
            }
            findAllSubArray(arr, start + 1, end, k);
        }
    }

    public int numSubarrayProductLessThanK(int[] arr, int k) {
        count = 0;
        findAllSubArray(arr, 0, 0, k);
        return count;
    }

    @Test
    public void test() {
        assertEquals(8, numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        // assertEquals(18, numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

}
