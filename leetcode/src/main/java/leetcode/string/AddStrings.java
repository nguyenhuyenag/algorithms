package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/add-strings/
 *
 * Cộng 2 số lớn dạng chuỗi
 *
 * Xem thêm: SumBigNumbers.java, SumStringsAsNumbers.java, SumOfString.java
 */
public class AddStrings {

    public String addStrings(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int max = Math.max(s1.length(), s2.length());
        int rem = 0;
        for (int i = 0; i < max; i++) {
            int n1 = i < s1.length() ? s1.charAt(s1.length() - 1 - i) - '0' : 0;
            int n2 = i < s2.length() ? s2.charAt(s2.length() - 1 - i) - '0' : 0;
            int sum = n1 + n2 + rem;
            rem = sum / 10;
            result.append(sum % 10);
        }
        if (rem > 0) {
            result.append(rem);
        }

        result.reverse();

        // Remove leading zeros
        while (result.length() >= 2 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    @Test
    public void doTest() {
        assertEquals("3", addStrings("1", "2"));
        assertEquals("579", addStrings("123", "456"));
        assertEquals("10367", addStrings("800", "9567"));
        assertEquals("8670", addStrings("00103", "08567"));
        assertEquals("0", addStrings("0", "0"));
    }

}
