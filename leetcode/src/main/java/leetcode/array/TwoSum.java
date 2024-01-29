package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/two-sum/
 *
 * Tìm 2 phần tử trong mảng sao cho tổng của chúng = n
 *
 * B1: Khởi tạo một HashSet s
 * B2: Loop i từ 0 -> n - 1
 *      - Nếu (sum - arr[i]) có trong s thì in ra cặp giá trị thoả(arr[i], sum - arr[i])
 *      - Thêm arr[i] vào s
 *
 * Xem thêm codewar > TwoSum.java
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int n) {
        int len = nums.length;
        int[] arr = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return arr;
    }

    public static void checkPairSumWayThree(int[] arr, int size_arr, int sum) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < size_arr; i++) {
            int tmp = sum - arr[i];
            if (s.contains(tmp) && tmp > 0)
                System.out.println("Cap gia tri thoa: (" + arr[i] + ", " + tmp + ")");
            s.add(arr[i]);
        }
    }

    public static void doTest(int[] A1, int[] A2) {
        Arrays.sort(A1);
        Arrays.sort(A2);
        assertArrayEquals(A1, A2);
    }

    @Test
    public void test() {
        doTest(twoSum(new int[]{3, 3}, 6), new int[]{1, 0});
        doTest(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        doTest(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 0});
    }

}
