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

    public String convertToTitle_OK(int columnNumber) {
        // @formatter:off
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;                     // Điều chỉnh columnNumber để làm cho nó bắt đầu từ 0
            int mod = columnNumber % 26;        // Lấy phần dư khi chia cho 26
            result.append((char) (mod + 'A'));  // Phần dư + 'A' sẽ ra vị trí
            columnNumber /= 26;
            // System.out.println("result.toString() = " + result);
        }
        // @formatter:on
        return result.reverse().toString();
    }

    public String convertToTitle(int n) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Integer, Character> table = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            table.put(i + 1, alphabet.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        // Tìm kích thước của bảng mẫu
        int size = table.size();
        while (n > 0) {
            n--; // Adjust n first to make 0-based index
            int position = n % size; // Directly use 0-based index
            result.append(table.get(position + 1)); // Offset the 0-based index for 1-based table access
            n /= size; // Update n for the next iteration
        }
        return result.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals("A", convertToTitle(1));
        assertEquals("AB", convertToTitle(28));
        assertEquals("ZY", convertToTitle(701));
        assertEquals("ABC", convertToTitle(731));
    }

}
