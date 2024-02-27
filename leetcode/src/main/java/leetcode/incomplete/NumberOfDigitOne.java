package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 *
 * Đếm số chữ số 1 của các số thuộc [0, n]
 */
public class NumberOfDigitOne {

    public int countDigitOneEach(int n) {
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            if (digit == 1) {
                count++;
            }
        }
        return count;
    }

    public int countDigitOne(int n) {
        int count = 0;
        if (n % 2 == 0) {
            count += countDigitOneEach(n);
            n--;
        }
        int l = 0, r = n;
        while (l < r) {
            count += countDigitOneEach(l);
            count += countDigitOneEach(r);
            l++;
            r--;
        }
        // System.out.println("l = " + l);
        // System.out.println("r = " + r);
        return count;
    }

    @Test
    public void test() {
        assertEquals(0, countDigitOne(0));
        assertEquals(1, countDigitOne(2));
        assertEquals(6, countDigitOne(13));
    }
}
