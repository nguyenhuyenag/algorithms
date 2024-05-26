package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/maximum-odd-binary-number/

    Cho số nguyên dạng nhị phân, tìm số nguyên lẻ lớn nhất từ dãy nhị phân này.

    Ý tưởng:
        - Số lớn nhất khi tất cả các bit 1 ở trên đầu.
        - Số nguyên lẻ khi biểu diễn nhị phân luôn luôn có một bit 1 ở cuối.
 */
public class MaximumBinaryOddNumber {

    public String maximumOddBinaryNumber(String str) {
        StringBuilder result = new StringBuilder();
        // Đếm số bit `1` trong chuỗi
        int oneCount = (int) str.chars().filter(c -> c == '1').count();
        // Tạo bit `1`
        for (int i = 0; i < oneCount - 1; i++) {
            result.append(1);
        }
        // Tạo bit `0`
        for (int i = 0; i < str.length() - oneCount; i++) {
            result.append(0);
        }
        // Thêm bit `1` ở cuối
        result.append(1);
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("001", maximumOddBinaryNumber("010"));
        assertEquals("1001", maximumOddBinaryNumber("0101"));
        assertEquals("101", maximumOddBinaryNumber("110"));
    }

}
