package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/transform-array-by-parity/

    Cho một mảng số nguyên nums. Hãy biến đổi nums bằng cách thực hiện
    đúng theo thứ tự các thao tác sau:

        - Thay mỗi số chẵn bằng 0.
        - Thay mỗi số lẻ bằng 1.
        - Sắp xếp mảng đã được thay đổi theo thứ tự không giảm (tăng dần).

    Hãy trả về mảng thu được sau khi thực hiện các thao tác trên.
*/
public class TransformArrayByParity {

    public int[] transformArray_OK(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] transformArray(int[] nums) {
        int[] result = new int[nums.length];
        int pleft = 0;                // Di chuyển từ trái -> phải sang và ghi số '0' vào mảng
        int pright = nums.length - 1; // Di chuyển từ phải -> trái và ghi số '1' vào mảng
        for (int num : nums) {
            if (num % 2 == 0) {
                result[pleft++] = 0;
            } else {
                result[pright--] = 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 0, 1, 1}, transformArray(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{0, 0, 1, 1, 1}, transformArray(new int[]{1, 5, 1, 4, 2}));
    }

}
