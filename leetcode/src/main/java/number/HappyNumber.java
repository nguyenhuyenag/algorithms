package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/happy-number/
 *
 * Số hạnh phúc là số mà tổng bình phương các chữ số liên tục, sau cho kết quả cuối cùng là số 1
 *
 * Input: n = 19 -> true
 *      12 + 92 = 82
 *      82 + 22 = 68
 *      62 + 82 = 100
 *      12 + 02 + 02 = 1
 */
public class HappyNumber {

    public int sumOfDigitsSquared(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        while (n > 9) {
            n = sumOfDigitsSquared(n);
        }
        return n == 1 || n == 7;
    }

    @Test
    public void test() {
        assertEquals(true, isHappy(19));
        assertEquals(false, isHappy(2));
        assertEquals(true, isHappy(7));
        assertEquals(true, isHappy(13));
    }

}
