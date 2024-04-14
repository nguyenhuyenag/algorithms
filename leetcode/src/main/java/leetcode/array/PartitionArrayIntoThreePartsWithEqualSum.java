package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

    Kiểm tra xem liệu có thể chia mảng thành 3 phần có tổng bằng nhau không?
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        // Nếu tổng không chia hết cho 3 -> không thể chia
        if (sum % 3 != 0) return false;

        sum /= 3; // Tổng của 1 đoạn

        int csum = 0; // Tính tồng của 1 đoạn
        int count = 0; // Đếm số đoạn có tổng = sum / 3
        for (int i = 0; i < nums.length; i++) {
            csum += nums[i];
            // Tìm được 1 đoạn thỏa mãn
            if (csum == sum) {
                // Reset current sum for the next part
                csum = 0;
                count++;
                /**
                 * Đã tìm được 2 đoạn thỏa mã yêu cầu & chưa duyệt hết mảng -> true vì
                 * sum chia hết cho 3 nên phần còn lại cũng chia hết cho 3
                 */
                if (count == 2 && i < nums.length - 1) return true;
            }
        }

        // If we have found three parts with sum equal to sum, return true
        return count == 3;
    }


    @Test
    public void test() {
        assertEquals(true, canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        assertEquals(true, canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        assertEquals(false, canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }

}
