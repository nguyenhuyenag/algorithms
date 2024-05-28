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

        1   ->  A
        2   ->  B
        3   ->  C
        ...
        26  ->  Z
        27  ->  AA
        28  ->  AB

    Từ [A, Z] có 26 ký tự.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            // @formatter:off
            columnNumber--;                     // Điều chỉnh columnNumber để làm cho nó bắt đầu từ 0
            int mod = columnNumber % 26;        // Lấy phần dư khi chia cho 26
            result.append((char) (mod + 'A'));  // Phần dư + 'A' sẽ ra vị trí
            columnNumber /= 26;
            // @formatter:on
            System.out.println("result.toString() = " + result);
        }
        return result.reverse().toString();
    }

    @Test
    public void test1() {
        assertEquals("A", convertToTitle(1));
        assertEquals("AB", convertToTitle(28));
        assertEquals("ZY", convertToTitle(701));
        assertEquals("ABC", convertToTitle(731));
    }

}
