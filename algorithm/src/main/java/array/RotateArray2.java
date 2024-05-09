package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Chuyển k phần tử đầu tiên về cuối mảng
 *
 * Xem thêm: Leetcode > RotateArray.java
 */
public class RotateArray2 {

    // [1, 2, 3, 4, 5]    ->    [3, 4, 5, 1, 2]
    public static void rotate(int[] nums, int k) {
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
    }

    public static void main(String[] args) {
        int k = 2; // chuyển k phần tử
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before:\t" + Arrays.toString(arr));
        rotate(arr, k);
        System.out.println("After:\t" + Arrays.toString(arr));
    }

}
