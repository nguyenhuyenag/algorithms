package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public long helper(long n) {
        StringBuilder numStr = new StringBuilder(String.valueOf(n));
        return Long.parseLong(numStr.reverse().toString());
    }

    public int reverse_OK(int n) {
        long result = n > 0 ? helper(n) : -helper(-n);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

//    public int reverse(int n) {
//        long result = 0;
//        int sign = n > 0 ? 1 : -1;
//        n = Math.abs(n);
//        while (n > 0) {
//            int digit = n % 10;
//            n /= 10;
//            result = 10 * result + digit;
//            if (sign * result < Integer.MIN_VALUE || sign * result > Integer.MAX_VALUE) {
//                return 0;
//            }
//        }
//        return (int) (sign * result);
//    }

    public int reverse(int n) {
        long result = 0;
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);

        while (n > 0) {
            result = 10 * result + n % 10;
            n /= 10;
        }

        result *= sign;

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }


    @Test
    public void test() {
        assertEquals(0, reverse(0));
        assertEquals(21, reverse(120));
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
    }

}
