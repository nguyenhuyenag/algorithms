package queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/

    Cho một mảng số nguyên nums, một số nguyên k, và một số nguyên multiplier.

    Bạn cần thực hiện k thao tác trên nums. Trong mỗi thao tác:

    - Tìm giá trị nhỏ nhất x trong nums. Nếu có nhiều giá trị nhỏ nhất trùng lặp, chọn giá
    trị xuất hiện đầu tiên. Thay thế giá trị nhỏ nhất đã chọn x bằng x * multiplier.

    - Trả về một mảng số nguyên biểu diễn trạng thái cuối cùng của nums sau khi thực hiện
    xong tất cả k thao tác.
 */
public class FinalArrayStateAfterKMultiplicationOperations {

    public int[] getFinalState_2(int[] nums, int k, int multiplier) {
        Comparator<Map.Entry<Integer, Integer>> comparator =
                Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
                        .thenComparingInt(Map.Entry::getKey);
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(Map.entry(i, nums[i]));
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                Map.Entry<Integer, Integer> e = pq.poll();
                pq.offer(Map.entry(e.getKey(), multiplier * e.getValue()));
            }
        }
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> e = pq.poll();
            nums[e.getKey()] = e.getValue();
        }
        return nums;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // PriorityQueue lưu chỉ số, so sánh dựa trên giá trị trong nums
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]); // So sánh theo giá trị
            }
            return Integer.compare(a, b); // Nếu giá trị bằng nhau, so sánh theo chỉ số
        });

        // Thêm tất cả các chỉ số vào PriorityQueue
        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }

        // Thực hiện k lần thay đổi
        for (int i = 0; i < k; i++) {
            int index = pq.poll(); // Lấy chỉ số có giá trị nhỏ nhất
            nums[index] *= multiplier; // Nhân giá trị nhỏ nhất với multiplier
            pq.offer(index); // Đưa lại vào PriorityQueue
        }

        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{8, 4, 6, 5, 6}, getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2));
        assertArrayEquals(new int[]{16, 8}, getFinalState(new int[]{1, 2}, 3, 4));
    }

}
