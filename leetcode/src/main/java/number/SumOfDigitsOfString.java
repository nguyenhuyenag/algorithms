package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 */
public class SumOfDigitsOfString {

    public int intOf(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            int value = (c - 'a') + 1; // Convert 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
            sum += value < 10 ? value : value / 10 + value % 10;
        }
        return sum;
    }

//    public int sumOfDigits(int n) {
//        int sum = 0;
//        while (n > 0) {
//            sum += n % 10;
//            n /= 10;
//        }
//        return sum;
//    }
//
//    public int getLucky(String s, int k) {
//        int n = intOf(s);
//        while (--k > 0) {
//            n = sumOfDigits(n);
//        }
//        return n;
//    }

    public int getLucky(String s, int k) {
        int n = intOf(s);
        while (--k > 0) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(8, getLucky("zbax", 2));
        assertEquals(36, getLucky("iiii", 1));
    }

}
