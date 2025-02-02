package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/maximum-width-ramp/

    Cho mảng số nguyên A. Tìm giá trị lớn nhất của j - i với i < j và A[i] <= A[j]
 */
public class MaximumWidthRamp {

    public int maxWidthRamp_time_limit_exceeded(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        int max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (visited.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] <= nums[j]) {
                        max = Math.max(max, j - i);
                    }
                }
            }
        }
        return max != -1 ? max : 0;
    }

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        // Stack lưu trữ các chỉ số của mảng sao cho các phần
        // tử tương ứng với các chỉ số này theo thứ tự giảm dần
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int max = 0;
        // Duyệt từ cuối mảng về đầu
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                max = Math.max(max, i - stack.pop());
            }
        }

        return max;
    }

    @Test
    public void test() {
        assertEquals(4, maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        assertEquals(7, maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

}
