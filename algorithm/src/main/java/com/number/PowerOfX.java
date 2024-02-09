package com.number;

/**
 * https://leetcode.com/problems/power-of-four/
 *
 * Cho số nguyên n, tìm x hoặc kiểm tra tồn tại sao cho a^x = n
 */
public class PowerOfX {

    // OK
    public static boolean isPowerOf4(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 4 == 0) {
                n /= 4;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int[] isPerfectPower(int n) {
        for (int a = 2; a * a <= n; a++) {
            int b = 2;
            while (Math.pow(a, b) <= n) {
                if (Math.pow(a, b) == n) {
                    return new int[]{a, b};
                }
                b++;
            }
        }
        return null;
    }

    public static boolean isPowerOfAny(int base, int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % base == 0) {
                n /= base;
            } else {
                return false;
            }
        }
        return true;
    }

    // CHECK

    public static boolean isPowerOfAny_Check(int base, int n) {
        if (n <= 0 || base <= 1) {
            return false;
        }
        while (n % base == 0) {
            n /= base;
        }
        return n == 1;
    }

    // Hàm lấy số mũ: getPower(2, 16) = 4 vì 2^4 = 16
    public static int getPower(int base, int number) {
        int power = 0;
        while (number % base == 0) {
            power++;
            number /= base;
        }
        return power;
    }

    public boolean isPowerOf3(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {

    }

}
