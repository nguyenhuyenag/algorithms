package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-closest-number-to-zero/
 *
 * Cho mảng số nguyên, tìm phần tử gần 0 nhất, nếu có nhiều kết quả thì trả về số lớn nhất.
 */
public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int zero = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, Math.abs(num - zero));
        }
        // Hàng đợi ưu tiên theo |x - 0|
        Queue<Integer> queue = new PriorityQueue<>((x1, x2) -> {
            int v1 = map.get(x1);
            int v2 = map.get(x2);
            return v1 != v2 ? v1 - v2 : x2 - x1;
        });
        queue.addAll(map.keySet());
        return queue.poll();
    }

    @Test
    public void test() {
        assertEquals(1, findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        assertEquals(1, findClosestNumber(new int[]{2, -1, 1}));
        assertEquals(1, findClosestNumber(new int[]{2, 1, 1, -1, 100000}));
    }
}
