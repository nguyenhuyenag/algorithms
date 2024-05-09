package queue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/57b06f90e298a7b53d000a86/
 *
 * Cho mảng số nguyên chứa n khách hàng và các giá trị đại diện cho thời
 * gian để hoàn thành thanh toán. Số nguyên k đại diện cho số quầy thành
 * toán. Tìm thời gian ít nhất cần có để tất cả các khách hàng thành toán xong
 *
 * queueTime([5,3,4], 1) = 12    -> Vì chỉ có 1 quầy nên 5 + 3 + 4 = 12
 *
 * queueTime([10,2,3,3], 2) = 10 -> Người thứ nhất ở quầy 1, ba người còn lại ở quầy 2
 * nên chỉ cần 10 phút
 */
public class TheSuperMarketQueue {

    public static int solveSuperMarketQueue(int[] times, int n) {
        // Tạo n quầy thanh toán (số nhỏ nhất sẽ được ưu tiên)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(0);
        }
        /**
         * Ở mỗi bước, khách hàng X có thời gian thanh toán nhỏ nhất sẽ hoàn thành trước nhất
         * nên ta lấy nó ra khỏi hàng đợi và thêm mới khách hàng Y.
         * Tổng thời gian thanh toán của khách hàng Y lúc này sẽ là: X + Y
         */
        for (int time : times) {
            int minTime = queue.remove();
            queue.add(minTime + time);
        }
        // Kết quả chính là max của queue
        return Collections.max(queue);
    }

    @Test
    public void test() {
        assertEquals(12, solveSuperMarketQueue(new int[]{5, 3, 4}, 1));
        assertEquals(10, solveSuperMarketQueue(new int[]{10, 2, 3, 3}, 2));
        assertEquals(9, solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    /**
     * Tìm index của phần tử nhỏ nhất
     */
    private static int findMinTimeIndex(int[] queue) {
        int minIndex = 0;
        for (int i = 1; i < queue.length; i++) {
            if (queue[i] < queue[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int solveSuperMarketQueue_OK(int[] times, int n) {
        int[] queue = new int[n];
        for (int time : times) {
            // Tìm quầy đang xử lý khách hàng có time nhỏ nhất
            int minIndex = findMinTimeIndex(queue);
            // Quầy nhỏ nhất sẽ hoàn thành, thay nó bằng time mới + time hiện tại
            queue[minIndex] += time;
        }
        return Arrays.stream(queue).max().orElse(0);
    }

}
