package leetcode.incomplete;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Cho mảng số nguyên biểu thị nhiệt độ của từng ngày. Trả về mảng số nguyên
 * cho biết phải mất bao lâu thì nhiệt độ sẽ tăng lên, nếu không có thì trả về 0
 *
 * [73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
 *
 * Sau ngày 73 độ là ngày 74 độ, tức là [1]
 * Sau ngày 74 độ là ngày 75 độ, tức là [1,1]
 * Sau ngày 75 độ thì phải đợi 4 ngày mới có ngày 76, tức là [1,1,4]
 * ....
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures_0(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // Nếu
            while (indexs.size() > 0 && nums[i] >= nums[indexs.peek()]) {
                indexs.pop();
            }
            if (indexs.size() > 0) {
                result[i] = indexs.peek() - i;
            }
            indexs.push(i);
        }
        return result;
    }



    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 1, 1, 0}, dailyTemperatures(new int[]{30, 40, 50, 60}));
        // assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

}
