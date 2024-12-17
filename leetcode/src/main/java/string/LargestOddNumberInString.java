package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 *
 * Cho số dạng chuỗi. Tìm số lẽ lớn nhất là chuỗi con của 1 chuỗi
 */
public class LargestOddNumberInString {

    // Duyệt ngược, kiểm tra nếu số ở vị trí đó lẻ -> số lẻ lớn nhất
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int currentChar = num.charAt(i);
            if (currentChar % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("5", largestOddNumber("52"));
        assertEquals("", largestOddNumber("4206"));
        assertEquals("35427", largestOddNumber("35427"));
    }

}
