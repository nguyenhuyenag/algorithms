package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Cho mảng số nguyên được sắp xếp, trả về mảng mới là bình phương
 * của mỗi phần tử cũng được sắp xếp
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num * num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }
}
