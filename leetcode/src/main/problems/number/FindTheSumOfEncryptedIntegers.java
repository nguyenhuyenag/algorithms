package number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

    Cho mảng số nguyên dương. Trả về tổng của các phần tử sau khi đã mã hóa theo quy tắc:

        Với mỗi số nguyên dương ta thay tất cả các chữ số bằng chữ số lớn nhất.
 */
public class FindTheSumOfEncryptedIntegers {

    public int encrypt(int n) {
        int maxDigit = 0;
        int countDigit = 0;
        // Find max digit
        while (n > 0) {
            maxDigit = Math.max(maxDigit, n % 10);
            n /= 10;
            countDigit++;
        }
        // Create max number
        int max = 0;
        for (int i = 0; i < countDigit; i++) {
            max = max * 10 + maxDigit;
        }
        return max;
    }

    public int sumOfEncryptedInt(int[] nums) {
        return Arrays.stream(nums).map(this::encrypt).sum();
    }

    @Test
    public void test() {
        assertEquals(6, sumOfEncryptedInt(new int[]{1, 2, 3}));
        assertEquals(66, sumOfEncryptedInt(new int[]{10, 21, 31}));
    }

    public int sumOfEncryptedInt_1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

}
