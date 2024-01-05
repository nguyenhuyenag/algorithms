package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Chúng ta phải giữ cho k luôn nằm trong khoảng từ [0, len - 1] để đảm bảo rằng việc xoay sẽ có ý nghĩa.
 *
 * Ví dụ, nếu len = 5, k = 7, thì việc rotate 7 phần tử sẽ giống như rotate 2 phần tử (vì 7 % 5 = 2). Do đó, chúng ta sử dụng k = k % len; để chắc chắn rằng giá trị của k không lớn hơn độ dài của mảng nums.
 */
public class MainLeet {

    // [1, 2, 3, 4, 5, 6, 7] -> [7, 1, 2, 3, 4, 5, 6]
    public int[] rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Đảm bảo k không lớn hơn độ dài của mảng

        List<Integer> result = new ArrayList<>();

        // Copy các phần tử cuối cùng sang mảng tạm
        for (int i = len - k; i < len; i++) {
            result.add(nums[i]);
        }

        // Copy các phần tử còn lại sang mảng tạm
        for (int i = 0; i < len - k; i++) {
            result.add(nums[i]);
        }

        // Gán lại giá trị cho nums
        for (int i = 0; i < len; i++) {
            nums[i] = result.get(i);
        }

        return nums;
    }

    public static int[] getResult(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.rotate(list, k);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testSomething() {
         assertArrayEquals(getResult(new int[]{-1, -100, 3, 99}, 2), rotate(new int[]{-1, -100, 3, 99}, 2));
         assertArrayEquals(getResult(new int[]{5, 6, 7, 1, 2, 3, 4}, 2), rotate(new int[]{5, 6, 7, 1, 2, 3, 4}, 2));
        assertArrayEquals(getResult(new int[]{1, 2, 3}, 4), rotate(new int[]{1, 2, 3}, 4));
    }

}
