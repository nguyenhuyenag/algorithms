package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/powerful-integers/

    Cho 3 số nguyên không âm x, y, m. Tìm tất cả các số nguyên a, sao cho tồn
    tại i >= 0, j >= 0 thỏa mãn a = x^i + y^j <= m.

    Example 1:
        Input: x = 2, y = 3, m = 10. Output: [2, 3, 4, 5, 7, 9, 10]
        Explanation:
            2   = 2^0 + 3^0
            3   = 2^1 + 3^0
            4   = 2^0 + 3^1
            5   = 2^1 + 3^1
            7   = 2^2 + 3^1
            9   = 2^3 + 3^0
            10  = 2^0 + 3^2
 */
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers_OK(int x, int y, int m) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; Math.pow(x, i) <= m; i++) {
            for (int j = 0; Math.pow(y, j) <= m; j++) {
                int num = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (num <= m) {
                    result.add(num);
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> powerfulIntegers(int x, int y, int m) {
        Set<Integer> result = new HashSet<>();
        int px = 1;
        while (px <= m) {
            int py = 1;
            while (px + py <= m) {
                result.add(px + py);
                if (y == 1) break; // Stop if y is 1, further powers won't change
                py *= y; // Compute next power of y
            }
            if (x == 1) break; // Stop if x is 1, further powers won't change
            px *= x; // Compute next power of x
        }
        return new ArrayList<>(result);
    }

    @Test
    public void test() {
        List<Integer> list = powerfulIntegers(2, 3, 10);
        list.sort(null);
        assertIterableEquals(List.of(2, 3, 4, 5, 7, 9, 10), list);
    }

}
