package codewars.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Map.*;
import static org.junit.jupiter.api.Assertions.*;

/*-
 *  https://www.codewars.com/kata/5270d0d18625160ada0000e4/
 *  Quy tắc tính điểm xúc xắc:
 *              3 mặt 1 => 1000 points
 *              3 mặt 6 =>  600 points
 *         (1)  3 mặt 5 =>  500 points
 *              3 mặt 4 =>  400 points
 *              3 mặt 3 =>  300 points
 *              3 mặt 2 =>  200 points
 *             ----------------------
 *         (2)  1 mặt 1 =>  100 points
 *              1 mặt 5 =>   50 point
 *  Cho mảng số nguyên đại diện cho số mặt mỗi lần ném, tính tổng điểm (số mặt chỉ được tính 1 lần)
 */
public class GreedIsGood {

    public int greedy(int[] dice) {
        Map<Integer, Integer> points = Map.ofEntries(
            entry(1, 1000),
            entry(6, 600),
            entry(5, 500),
            entry(4, 400),
            entry(3, 300),
            entry(2, 200)
        );
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : dice) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
        }
        int total = 0;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value >= 3) {
                total += points.get(key) * (value / 3);
            }

            if (key == 1) {
                total += 100 * (value % 3);
            } else if (key == 5) {
                total += 50 * (value % 3);
            }
        }

        return total;
    }

    @Test
    public void test() {
        assertEquals(250, greedy(new int[]{5, 1, 3, 4, 1}));
        assertEquals(0, greedy(new int[]{2, 3, 4, 6, 2}));
        assertEquals(1100, greedy(new int[]{1, 1, 1, 3, 1}));
        assertEquals(450, greedy(new int[]{2, 4, 4, 5, 4}));
    }

}
