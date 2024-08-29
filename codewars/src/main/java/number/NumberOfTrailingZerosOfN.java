package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/52f787eb172a8b4ae1000a34/

    - Đếm số lượng số 0 ở cuối của n!

    - Số 0 xuất chỉ xuất hiện khi 2 x 5. Do đó chỉ cần đếm số lượng bội số 5 (đếm số mũ của 5).
 */
public class NumberOfTrailingZerosOfN {

    public static int zeros(int n) {
        int factor = 5;
        int count = 0;
        while (factor <= n) {
            count += (n / factor);
            factor *= 5;
        }
        return count;
    }

    public static int zeros_1(int n) {
        int s = 0;
        int base = 5;
        while (n > 0) {
            n /= base;
            s += n;
        }
        return s;
    }

    public static int zeros_2(int n) {
        if (n == 0) return 0;
        return n / 5 + zeros_2(n / 5);
    }

    @Test
    public void testZeros() {
        assertEquals(0, zeros(0));
        assertEquals(1, zeros(6));
        assertEquals(2, zeros(14));
    }

}
