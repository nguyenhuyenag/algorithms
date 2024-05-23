package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/count-numbers-with-unique-digits/
    Cho số nguyên n, đếm số có chữ số không giống nhau trong 0 <= n < 10^n.

    Ví dụ: n = 2 => 91 số (sau khi bỏ 11, 22, 33, 44, 55, 66, 77, 88, 99)
 */
public class CountNumberWithUniqueDigits {

    public boolean isUnique(int n) {
        Set<Integer> unique = new HashSet<>();
        while (n > 0) {
            int digit = n % 10;
            if (!unique.add(digit)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public int countNumbersWithUniqueDigits(int n) {
        int count = 0;
        for (int i = 0; i < Math.pow(10, n); i++) {
            if (isUnique(i)) count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(91, countNumbersWithUniqueDigits(2));
        // System.out.println("check = " + isUnique(11));
    }

}
