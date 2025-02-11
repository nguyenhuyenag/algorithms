package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.*;


/**
 * https://leetcode.com/problems/two-sum/
 *
 * Tìm 2 phần tử trong mảng sao cho tổng của chúng = k
 *
 * B1: Khởi tạo một HashSet s
 * B2: Loop i từ 0 -> n - 1
 * - Nếu (sum - arr[i]) có trong s thì in ra cặp giá trị thoả(arr[i], sum - arr[i])
 * - Thêm arr[i] vào s
 *
 * Xem thêm codewar > TwoSum.java
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int k) {
        // <num, index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n2 = k - nums[i];
            int j = map.getOrDefault(n2, -1); // Index of n2
            if (j != -1) {
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public void doTest(int[] A1, int[] A2) {
        Arrays.sort(A1);
        Arrays.sort(A2);
        assertArrayEquals(A1, A2);
    }

    @Test
    public void test() {
        doTest(new int[]{1, 0}, twoSum(new int[]{3, 3}, 6));
        doTest(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        doTest(new int[]{1, 0}, twoSum(new int[]{2, 7, 11, 15}, 9));
    }

}
