package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/multiply-strings/description/
 *
 *              2 7
 *          x   3 6
 *       -----------
 *            1 6 2
 *            8 1
 *       -----------
 *            9 7 2
 */
public class MultiplyStrings {

    /**
     * Xóa số 0 ở đầu số dạng chuỗi
     */
    private static String removeLeadingZeros(StringBuilder input) {
        int len = input.length();
        int index = 0;
        while (index < len && input.charAt(index) == '0') {
            index++;
        }
        return index == len ? "0" : input.substring(index);
    }

    /**
     * Cộng 2 số
     */
    private String addStrings(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int len1 = s1.length(), len2 = s2.length();
        int max = Math.max(len1, len2);
        int rem = 0;
        for (int i = 0; i < max; i++) {
            int n1 = i < len1 ? s1.charAt(len1 - 1 - i) - '0' : 0;
            int n2 = i < len2 ? s2.charAt(len2 - 1 - i) - '0' : 0;
            int sum = n1 + n2 + rem;
            result.append(sum % 10);
            rem = sum / 10;
        }
        if (rem > 0) {
            result.append(rem);
        }
        result.reverse();
        return removeLeadingZeros(result);
    }

    /**
     * Nhân 2 số
     */
    public String multiply(String num1, String num2) {
        String result = "0";
        int p = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            int rem = 0;
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int product = n1 * n2 + rem;
                builder.append(product % 10);
                rem = product / 10;
            }
            if (rem > 0) {
                builder.append(rem);
            }
            builder.reverse().append("0".repeat(p++));
            result = addStrings(result, builder.toString());
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals("972", multiply("36", "27"));
        assertEquals("56088", multiply("123", "456"));
        assertEquals("838102050", multiply("12345", "67890"));
    }

}
