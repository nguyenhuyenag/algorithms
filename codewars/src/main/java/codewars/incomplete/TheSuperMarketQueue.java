package codewars.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/57b06f90e298a7b53d000a86/
 *
 * Cho mảng số nguyên chứa n khách hàng và các giá trị đại diện cho thời
 * gian để hoàn thành thanh toán. Số nguyên k đại diện cho số quầy thành
 * toán.
 * Tìm thời gian ít nhất cần có để tất cả các khách hàng thành toán xong
 *
 * queueTime([5,3,4], 1) = 12    -> Vì chỉ có 1 quầy nên 5 + 3 + 4 = 12
 *
 * queueTime([10,2,3,3], 2) = 10 -> Người thứ nhất ở quầy 1, ba người còn lại ở quầy 2
 * nên chỉ cần 10 phút
 */
public class TheSuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(12, solveSuperMarketQueue(new int[]{5, 3, 4}, 1));
        assertEquals(10, solveSuperMarketQueue(new int[]{10, 2, 3, 3}, 2));
    }

}
