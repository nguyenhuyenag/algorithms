package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/hamming-distance/
 *
 * Đếm số khác nhau tương tứng của 2 số nguyên trong biểu diễn nhị phân
 *
 *  1   (0 0 0 1)
 *  4   (0 1 0 0)
 *         ↑   ↑     -> Kết quả = 2
 */
public class HamingDistance {

    public int hammingDistance(int x, int y) {
        String b1 = Integer.toString(x, 2);
        String b2 = Integer.toString(y, 2);
        int count = 0;
        int len1 = b1.length(), len2 = b2.length();
        int max = Math.max(len1, len2);
        for (int i = 0; i < max; i++) {
            char c1 = i < len1 ? b1.charAt(len1 - 1 - i) : '0';
            char c2 = i < len2 ? b2.charAt(len2 - 1 - i) : '0';
            if (c1 != c2) count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, hammingDistance(1, 4));
        assertEquals(1, hammingDistance(1, 3));
    }
}
