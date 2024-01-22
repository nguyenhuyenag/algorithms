package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 *
 * Tìm số lẽ lớn nhất là chuỗi con của 1 chuỗi
 */
public class LargestOddNumberInString {

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
