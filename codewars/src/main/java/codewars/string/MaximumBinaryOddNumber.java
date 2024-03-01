package codewars.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/maximum-odd-binary-number/
 *
 * Cho số nguyên dạng nhị phân, tìm số nguyên lẻ lớn nhất từ dãy nhị phân này.
 *
 * Ý tưởng:
 *      (1) Số lớn nhất khi tất cả các bit 1 ở trên đầu
 *      (2) Số nguyên lẻ khi biểu diễn nhị phân luôn luôn có một bit 1 ở cuối.
 */
public class MaximumBinaryOddNumber {

    public String maximumOddBinaryNumber(String s) {
        StringBuilder result = new StringBuilder();
        int oneCount = (int) s.chars().filter(c -> c == '1').count();
        result.append("1".repeat(oneCount - 1));
        result.append("0".repeat(s.length() - oneCount));
        result.append("1");
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("001", maximumOddBinaryNumber("010"));
        assertEquals("1001", maximumOddBinaryNumber("0101"));
        assertEquals("101", maximumOddBinaryNumber("110"));
    }

}
