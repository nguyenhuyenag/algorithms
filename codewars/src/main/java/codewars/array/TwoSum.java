package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://www.codewars.com/kata/52c31f8e6605bcc646000082/
 *
 * Tìm 2 số trong mảng có tổng bằng n. Trả về index của 2 số đó
 */
public class TwoSum {

    public int[] twoSum(int[] arr, int target) {
        // lưu <số, chỉ số>
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) { // nums[i] là số thứ nhất
            int num2 = target - arr[i]; // số thứ 2

            // Nếu num2 trong map, trả về mảng chứa 2 index
            if (map.containsKey(num2)) {
                return new int[]{i, map.get(num2)};
            }

            // Thêm phần tử hiện tại vào map nếu chưa có
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        // Nếu không tìm thấy cặp phần tử, trả về mảng chứa -1
        return new int[]{-1, -1};
    }

    public static void compareArray(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        assertArrayEquals(A, B);
    }

    @Test
    public void test() {
        compareArray(new int[]{1, 2}, twoSum(new int[]{2, 3, 1}, 4));
        compareArray(new int[]{0, 2}, twoSum(new int[]{1, 2, 3}, 4));
        compareArray(new int[]{0, 1}, twoSum(new int[]{2, 2, 3}, 4));
        compareArray(new int[]{1, 2}, twoSum(new int[]{1234, 5678, 9012}, 14690));
    }

}
