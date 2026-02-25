package number.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/counting-bits/
 *
 * Cho số nguyên n. Với mỗi i thuộc [0, n] đếm số bit '1' trong biểu diễn nhị phân của i.
 * Trả về mảng n + 1 kết quả trên.
 */
public class CoutingBits {

    public int myBitCount(int n) {
        int count = 0;
        while (n > 0) {
            int mod = n % 2;
            if (mod == 1) count++;
            n /= 2;
        }
        return count;
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = myBitCount(i);
            // result[i] = Integer.bitCount(i);
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
    }
}
