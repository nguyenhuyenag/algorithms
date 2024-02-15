package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Cho một dãy số nguyên, tìm số nguyên dương nhỏ nhất bị thiếu trong dãy
 *
 * [1, 2, 0]   ->  3
 * [7, 8, 9]   ->  1
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (num > 0 && !visited.contains(num)) {
                queue.add(num);
                visited.add(num);
            }
        }
        int current = 0; // Bắt đầu từ 0
        while (!queue.isEmpty()) {
            // Nếu current + 1 (số kế tiếp) không phải là số kế tiếp (ở đỉnh) thì nó là số bị thiếu
            if (current + 1 != queue.peek()) {
                return current + 1;
            }
            current = queue.poll(); // Gán số ở đỉnh là số hiện tại
        }
        return current + 1;
    }


    @Test
    public void test() {
        assertEquals(3, firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(3, firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
    }

//    public static int firstMissingPositive(int[] nums) {
//        int current = 0; // Số nguyên dương hiện tại
//        while (!queue.isEmpty()) {
//            if (++current != queue.poll()) {
//                return current;
//            }
//        }
//    }

}
