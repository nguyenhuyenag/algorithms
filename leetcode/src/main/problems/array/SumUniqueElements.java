package array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
	https://leetcode.com/problems/sum-of-unique-elements/

	Tính tổng các phần tử duy nhất trong mảng.
 */
public class SumUniqueElements {

    public int sumOfUnique_OK(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : nums) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
        }
        int sum = 0;
        for (int x : counter.keySet()) {
            if (counter.get(x) == 1) {
                sum += x;
            }
        }
        return sum;
    }

    public int sumOfUnique(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : nums) {
            if (!counter.containsKey(x)) {
                // Nếu chưa có thì cộng vào sum
                counter.put(x, 1);
                sum += x;
            } else if (counter.get(x) == 1) {
                // Nếu đã có thì đánh dấu và giảm sum xuống vì x không phải duy nhất
                counter.put(x, 2);
                sum -= x;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(4, sumOfUnique(new int[]{1, 2, 3, 2}));
    }

}
