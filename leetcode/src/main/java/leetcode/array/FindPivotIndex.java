package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/find-pivot-index/

    Cho mảng số nguyên n phần tử, tìm vị trí i (đếm từ 1) chia mảng thành 2 phần

        arr[0] + arr[1] + ... + arr[i - 1] = arr[i + 1] + arr[i + 2] + ... + arr[n - 1]

    Nếu không có thì trả về -1.
 */
public class FindPivotIndex {

    // Nếu i = 0  thì leftSum = 0 do không có phần tử nào, tương tự cho rightSum khi i ở cuối
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
    }

}
