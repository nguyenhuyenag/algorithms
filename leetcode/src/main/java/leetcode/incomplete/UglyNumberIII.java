package leetcode.incomplete;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Chủ đề: Quy hoạch động, dynamic programing
 *
 * https://leetcode.com/problems/ugly-number-iii/
 *
 * Ta sẽ tạo 1 mảng gồm n số ugly từ số ugly đầu tiên là 1, bằng cách nhân lần lượt cho 2, 3, 5
 * và mỗi bước ta sẽ chọn số nhỏ nhất
 *
 * k_1 = min(2k_0, 3k_0, 5k_0) = 2k_0 = 2. So we move p2 pointer to 1.
 *
 * k_2 = min(2k_1, 3k_0, 5k_0) = 3k_0 = 3. So we move p3 pointer to 1, ...
 */
public class UglyNumberIII {

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int ugly = 0;
        int pa = 1, pb = 1, pc = 1;
        while (n > 0) {
            ugly = min(a * pa, b * pb, c * pc);
            if (ugly == a * pa) pa++;
            if (ugly == b * pb) pb++;
            if (ugly == c * pc) pc++;
            n--;
        }
        return ugly;
    }

    @Test
    public void test() {
        // assertEquals(4, nthUglyNumber(3, 2, 3, 5));
        // assertEquals(6, nthUglyNumber(4, 2, 3, 4));
        // assertEquals(10, nthUglyNumber(5, 2, 11, 13));
        assertEquals(1999999984, nthUglyNumber(1_000_000_000, 2, 217983653, 336916467));
    }

}
