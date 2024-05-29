package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/perfect-number/

    Số hoàn hảo là số bằng tổng các ước của nó (trừ chính nó).
 */
public class CheckPerfectNumber {

    public boolean checkPerfectNumber_1(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    public boolean checkPerfectNumber_2(int n) {
        if (n == 1) return false;
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    public boolean checkPerfectNumber(int n) {
        if (n == 1) return false;
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    @Test
    public void test() {
        assertEquals(true, checkPerfectNumber(28));
    }

}
