package queue;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/minimum-increment-to-make-array-unique/

    Cho mảng số nguyên nums. Ở mỗi bước ta có thể tăng một nums[i] lên 1. Tìm số bước nhỏ nhất
    để mảng nums chỉ chứa các phần tử duy nhất.

    Example 1: Input: nums = [1,2,2] => Output: 1
    Explanation: After 1 move, the array could be [1, 2, 3].
 */
public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique_OK(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        int countMoves = 0;
        int current = queue.poll();

        while (!queue.isEmpty()) {
            if (current >= queue.peek()) {
                countMoves += current + 1 - queue.peek();
                current++;
                queue.poll();
            } else {
                current = queue.poll();
            }
        }
        return countMoves;
    }

    public int minIncrementForUnique_2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int moves = nums[i - 1] - nums[i] + 1;
                count += moves;
                // Cập nhật nums[i] để đảm bảo nó là duy nhất
                nums[i] += moves;
            }
        }
        return count;
    }

    public int minIncrementForUnique_3(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int temp = num;
            while (!set.add(temp)) {
                temp++;
                count++;
            }
        }
        return count;
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (prev < current) { // pass
                prev = current;
            } else { // prev >= current
                prev++;
                int diff = prev - current;
                total += diff;
            }
        }
        return total;
    }

    @Test
    public void test() {
        // assertEquals(1, minIncrementForUnique(new int[]{1, 2, 2}));
        assertEquals(6, minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

}
