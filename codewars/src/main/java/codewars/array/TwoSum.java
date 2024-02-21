package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/52c31f8e6605bcc646000082/
 *
 * Tìm 2 số trong mảng có tổng bằng n. Trả về index của 2 số đó
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        // Map lưu <Value, Index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];       // Số thứ nhất
            int n2 = target - n1;   // Số thứ hai
            int j = map.getOrDefault(n2, -1); // Thử lấy index của số thứ 2
            if (j != -1) {
                return new int[]{i, j};
            }
            // Đẩy số hiện tại vào map
            map.put(n1, i);
        }
        return result;
    }

    @Test
    public void test() {
        compareArray(new int[]{1, 2}, twoSum(new int[]{2, 3, 1}, 4));
        compareArray(new int[]{0, 2}, twoSum(new int[]{1, 2, 3}, 4));
        compareArray(new int[]{0, 1}, twoSum(new int[]{2, 2, 3}, 4));
        compareArray(new int[]{1, 2}, twoSum(new int[]{1234, 5678, 9012}, 14690));
    }

    public static void compareArray(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        assertArrayEquals(A, B);
    }

}
