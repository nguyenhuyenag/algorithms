package number;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/excel-sheet-column-number/

    Cho chuỗi đại diện cho cột trong Excel, in ra số thứ tự của cột

        A   ->  1
        B   ->  2
        C   ->  3
        ...
        Z   ->  26
        AA  ->  27
        AB  ->  28

    Từ [A, Z] có 26 ký tự.
 */
public class ExcelSheetColumnNumber {

    /*
        "B" = 2
        "BC" = (2)26 + 3
        "BCM" = (2(26) + 3)26 + 13
     */
    public int titleToNumber_OK(String title) {
        int sum = 0;
        for (char c : title.toCharArray()) {
            sum = 26 * sum;
            sum += c + 1 - 'A';
        }
        return sum;
    }

    public int titleToNumber(String title) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            table.put(alphabet.charAt(i), i + 1);
        }
        int radix = table.size();
        int sum = 0;
        for (char c : title.toCharArray()) {
            sum = radix * sum + table.get(c);
        }
        return sum;
    }

    @Test
    public void test2() {
        assertEquals(731, titleToNumber("ABC"));
        assertEquals(701, titleToNumber("ZY"));
    }

}
