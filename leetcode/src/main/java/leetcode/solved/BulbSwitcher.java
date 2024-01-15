package leetcode.solved;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/bulb-switcher/
 *
 * Cho n bóng đèn:
 *
 * B1: Bật tất cả
 * B2: Bật tất cả các vị trí là bội của 2
 * B3: ...
 *
 * Đếm số bóng đèn sau khi hoàn thành các bước
 *
 * Step: https://leetcode.com/problems/bulb-switcher/Figures/319/Slide.PNG
 */
public class BulbSwitcher {

    public static int count(boolean[] arr) {
        int count = 0;
        for (boolean v : arr) {
            if (v) {
                count++;
            }
        }
        return count;
    }

    // Time Limit Exceeded for n = 99999999
    public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        Arrays.fill(bulbs, true); // Bước 1
        for (int i = 2; i <= n; i++) { // Thay đổi bắt đầu từ 2
            for (int j = i - 1; j < n; j += i) { // Thay đổi bắt đầu từ i - 1 và bước nhảy là i
                bulbs[j] = !bulbs[j]; // Chuyển đổi mỗi bóng đèn thứ i
            }
        }
        return count(bulbs);
    }

    @Test
    public void test() {
        assertEquals(1, bulbSwitch(3));
        assertEquals(0, bulbSwitch(0));
        assertEquals(1, bulbSwitch(1));
        assertEquals(2, bulbSwitch(4));
    }

}
