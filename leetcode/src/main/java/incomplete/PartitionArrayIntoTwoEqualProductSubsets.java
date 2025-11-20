package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/partition-array-into-two-equal-sum-subsets/
 *
 * Cho mảng chứa số nguyên phân biệt và số nguyên k. Kiểm tra xem có thể chia
 * mảng thành 2 mảng con sau cho tích của mỗi mảng con đều bằng k.
 */
public class PartitionArrayIntoTwoEqualProductSubsets {

    public boolean checkEqualPartitions(int[] nums, long target) {
        return false;
    }

    @Test
    public void test() {
        assertEquals(24, checkEqualPartitions(new int[]{3, 1, 6, 8, 4}, 24));
    }

}
