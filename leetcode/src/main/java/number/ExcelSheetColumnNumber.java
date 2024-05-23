package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class ExcelSheetColumnNumber {

    /*
        "B" = 2
        "BC" = (2)26 + 3
        "BCM" = (2(26) + 3)26 + 13
     */
    public int titleToNumber(String title) {
        int sum = 0;
        for (char c : title.toCharArray()) {
            sum = 26 * sum;
            sum += c + 1 - 'A';
        }
        return sum;
    }

    @Test
    public void test2() {
        assertEquals(731, titleToNumber("ABC"));
        assertEquals(701, titleToNumber("ZY"));
    }

}
