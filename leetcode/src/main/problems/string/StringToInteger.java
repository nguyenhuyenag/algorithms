package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement hàm atoi trong C++
 */
public class StringToInteger {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0; // Nếu chuỗi rỗng -> 0
        }

        char firstChar = s.charAt(0);
        // Tìm dấu và vị trí bắt đầu duyệt
        int sign = 1, startIndex = 0;
        if (firstChar == '-' || firstChar == '+') {
            startIndex = 1;
            sign = firstChar == '-' ? -1 : 1;
        }

        long result = 0;
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            // Nếu gặp một ký tự không phải là số thì thoát
            if (!Character.isDigit(c))
                break;
            result = 10 * result + Character.getNumericValue(c);
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return sign * (int) result;
    }

    @Test
    public void test() {
        assertEquals(42, myAtoi("42"));
        assertEquals(-42, myAtoi("-42"));
        assertEquals(123, myAtoi("123 abc"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(3, myAtoi("3.14159"));
    }
}
