package codewars.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5324945e2ece5e1f32000370/
 *
 * Cộng 2 số as string
 *
 * Xem thêm: SumOfTwoIntegers.java
 */
public class SumStringsAsNumbers {

    public static String leftPad(String s, int lenRequired) {
        int numZeros = Math.max(0, lenRequired - s.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numZeros; i++) {
            ans.append('0');
        }
        ans.append(s);
        return ans.toString();
    }

    public static String sumStrings0(String a, String b) {
        int len = Math.max(a.length(), b.length());
        a = leftPad(a, len);
        b = leftPad(b, len);
        int ghiNho = 0; // Số nhớ
        StringBuilder ans = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + ghiNho;
            ans.insert(0, sum % 10);
            ghiNho = sum / 10;
        }
        if (ghiNho > 0) {
            ans.insert(0, ghiNho);
        }
        return ans.toString().replaceFirst("^0+", "");
    }

    public static String sumStrings(String a, String b) {
        final int len = Math.max(a.length(), b.length());
        String x = leftPad(a, len + 1);
        String y = leftPad(b, len + 1);
        int rem = 0;
        final StringBuilder result = new StringBuilder(len + 1);
        for (int i = len; i >= 0; i--) {
            int sum = Integer.parseInt("" + x.charAt(i)) + Integer.parseInt("" + y.charAt(i)) + rem;
            result.insert(0, sum % 10);
            rem = sum / 10;
        }
        return result.toString().replaceFirst("^0+", "");
    }

    @Test
    public void doTest() {
        assertEquals("3", sumStrings("1", "2"));
        assertEquals("579", sumStrings("123", "456"));
        assertEquals("10367", sumStrings("800", "9567"));
        assertEquals("8670", sumStrings("00103", "08567"));
    }

}
