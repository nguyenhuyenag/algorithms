package number;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/next-greater-element-ii/

    Cho mảng số nguyên nums dạng vòng (phần tử tiếp theo của nums[nums.length - 1] là nums[0]),
    trả về số lớn hơn tiếp theo cho mỗi phần tử trong nums.

    Số lớn hơn tiếp theo của một số x là số lớn đầu tiên theo thứ tự duyệt tiếp theo của nó
    trong mảng, có nghĩa là bạn có thể tìm kiếm vòng tròn để tìm số lớn hơn tiếp theo của nó.
    Nếu không tồn tại, trả về -1 cho số này.

    Example: nums = [1,2,1] -> [2,-1,2]
 */
public class NextGreaterElementII {

    public int find(int[] nums, int len, int index) {
        // index...end
        for (int i = index; i < len; i++) {
            if (nums[i] > nums[index]) {
                return nums[i];
            }
        }
        // 0...index
        for (int i = 0; i < index; i++) {
            if (nums[i] > nums[index]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int[] nextGreaterElements_OK(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = find(nums, len, i);
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int number = nums[i];
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            nums[i] = stack.empty() ? -1 : stack.peek();
            stack.push(number);
        }
        return nums;
    }

    @Test
    public void test() {
        // assertArrayEquals(new int[]{2, -1, 2}, nextGreaterElements(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{2, 3, 4, -1, 4}, nextGreaterElements(new int[]{1, 2, 3, 4, 3}));
    }

}
