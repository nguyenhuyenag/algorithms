package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/5659c6d896bc135c4c00021e/
 *
 * Cho số nguyên dương n. Tìm số nguyên dương gần n nhất có cùng chữ số
 */
public class NextSmalleWithTheSameDigits {

    public static boolean checkSameDigits(long n1, int n2) {
        int[] mark = new int[10];
        while (n1 > 0 && n2 > 0) {
            int d1 = (int) (n1 % 10);
            int d2 = n2 % 10;
            mark[d1]++;
            mark[d2]--;
            n1 /= 10;
            n2 /= 10;
        }
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static long nextSmaller(long n) {
        int len = String.valueOf(n).length();
        for (int i = (int) (n - 1); i >= Math.pow(10, len - 1); i--) {
            if (checkSameDigits(n, i)) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(12, nextSmaller(21));
        assertEquals(414, nextSmaller(441));
        assertEquals(513, nextSmaller(531));
        assertEquals(790, nextSmaller(907));
        assertEquals(2017, nextSmaller(2071));
        assertEquals(123456789, nextSmaller(123456798));
        // assertEquals(2017, nextSmaller(9_999_999_999));
    }
}
