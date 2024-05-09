package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/
 *
 * Nhân các chữ số lại với nhau cho đến khi kết quả cuối cùng < 10. Trả về số bước thực hiện
 *
 *      39 --> 3 (thực hiện 3 lần 3*9 = 27, 2*7 = 14, 1*4 = 4)
 *
 *      999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, 1*2 = 2)
 *
 *      4 --> 0 (because 4 is already a one-digit number)
 *
 * Xem thêm: leetcode > AddDigits
 */
public class PersistentBugger {

    public int multiplyDigits(long n) {
        int result = 1;
        while (n > 0) {
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

    public int persistence(long n) {
        int count = 0;
        while (n > 9) {
            n = multiplyDigits(n);
            count++;
        }
        return count;
    }

    @Test
    public void doTest() {
        assertEquals(3, persistence(39));
        assertEquals(4, persistence(999));
        assertEquals(0, persistence(4));
    }

}
