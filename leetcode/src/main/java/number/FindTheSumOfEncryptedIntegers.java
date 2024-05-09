package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-the-sum-of-encrypted-integers/
 *
 * Quy tắc mã hóa: Với mỗi số nguyên ta thay tất cả các chữ số bằng chữ số lớn nhất.
 *
 * Cho mảng số nguyên. Trả về tổng của các phần tử sau khi đã mã hóa
 */
public class FindTheSumOfEncryptedIntegers {

    public int encrypt(int n) {
        int maxDigit = 0;
        int countDigit = 0;
        while (n > 0) {
            maxDigit = Math.max(maxDigit, n % 10);
            n /= 10;
            countDigit++;
        }
        int max = 0;
        for (int i = 0; i < countDigit; i++) {
            max = max * 10 + maxDigit;
        }
        return max;
    }

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(6, sumOfEncryptedInt(new int[]{1, 2, 3}));
        assertEquals(66, sumOfEncryptedInt(new int[]{10, 21, 31}));
    }

}
