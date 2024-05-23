package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/excel-sheet-column-title/

    Cho số nguyên, in ra chuỗi đại diện của cột đó.

        A   <->  1
        B   <->  2
        C   <->  3
        ...
        Z   <->  26
        AA  <->  27
        AB  <->  28

    Từ [A, Z] có 26 ký tự.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Điều chỉnh columnNumber để làm cho nó bắt đầu từ 0
            int mod = columnNumber % 26; // Lấy phần dư khi chia cho 26
            result.append((char) (mod + 'A')); // Phần dư + 'A' sẽ ra vị trí
            columnNumber /= 26;
            System.out.println("result.toString() = " + result);
        }
        return result.reverse().toString();
    }

    public int convertTitleToNumber(String title) {
        int result = 0;
        for (int i = 0; i < title.length(); i++) {
            char ch = title.charAt(i);
            int value = ch + 1 - 'A';
            result = 26 * result + value;
        }
        return result;
    }

    @Disabled
    @Test
    public void test1() {
        // assertEquals("A", convertToTitle(1));
        // assertEquals("AB", convertToTitle(28));
        // assertEquals("ZY", convertToTitle(701));
        assertEquals("ABC", convertToTitle(731));
    }

    @Test
    public void test2() {
        assertEquals(731, convertTitleToNumber("ABC"));
        assertEquals(701, convertTitleToNumber("ZY"));
    }

}
