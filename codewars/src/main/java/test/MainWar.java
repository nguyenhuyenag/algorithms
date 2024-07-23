package test;

import org.junit.jupiter.api.Test;

import java.util.*;

/*

 */
public class MainWar {

    public static boolean check(long n) {
        long sum = 0;
        char[] digits = Long.toString(n).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            int digit = Character.getNumericValue(digits[i]);
            sum += (long) Math.pow(digit, i + 1);
        }
        return n == sum;
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            if (check(i)) {
                result.add(i);
            }
        }
        return result;
    }

    @Test
    public void sampleTests() {
        System.out.println(check(89));
        System.out.println(check(135));
    }

}
