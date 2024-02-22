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

    // Xóa số 0 ở đầu số dạng chuỗi
    public static String removeLeadingZeros(StringBuilder input) {
        int len = input.length();
        int index = 0;
        while (index < len && input.charAt(index) == '0') {
            index++;
        }
        return index == len ? "0" : input.substring(index);
    }

    public String addStrings(String s1, String s2) {
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

    @Test
    public void doTest() {
        assertEquals("3", addStrings("1", "2"));
        assertEquals("579", addStrings("123", "456"));
        assertEquals("10367", addStrings("800", "9567"));
        assertEquals("8670", addStrings("00103", "08567"));
        assertEquals("0", addStrings("0", "0"));
    }

    //    public String addStrings(String s1, String s2) {
//        StringBuilder result = new StringBuilder();
//
//        // Remove leading zeros
//        s1 = s1.replaceFirst("^0+(?!$)", "");
//        s2 = s2.replaceFirst("^0+(?!$)", "");
//
//        int len1 = s1.length(), len2 = s2.length();
//        int max = Math.max(len1, len2);
//
//        int rem = 0;
//
//        for (int i = 0; i < max; i++) {
//            int n1 = i < len1 ? s1.charAt(len1 - 1 - i) - '0' : 0;
//            int n2 = i < len2 ? s2.charAt(len2 - 1 - i) - '0' : 0;
//            int sum = n1 + n2 + rem;
//            result.append(sum % 10);
//            rem = sum / 10;
//        }
//
//        if (rem > 0) {
//            result.append(rem);
//        }
//
//        return result.reverse().toString();
//    }

}
