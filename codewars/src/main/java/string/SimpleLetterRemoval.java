package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5b728f801db5cec7320000c7/
 *
 * Ở mỗi bước ta xóa 1 ký tự 'a', sau khi hết 'a' thì chuyển qua b. Trả về chuỗi sau k bước
 */
public class SimpleLetterRemoval {

    public static String solve0(String s, int k) {
        for (var c : "abcdefghijklmnopqrstuvwxyz".split("")) {
            while (!s.isEmpty() && s.contains(c) && k-- > 0) {
                s = s.replaceFirst(c, "");
            }
        }
        return s;
    }

    public static String solve(String str, int k) {
        char ch = 'a';
        while (k > 0 && str.length() > 0) {
            String c = String.valueOf(ch);
            if (str.contains(c)) {
                str = str.replaceFirst(c, "");
                k--; // Xóa thành công mới hoàn thành 1 bước, chứ không phải đặt k-- ở cuối while
            } else {
                ch++;
            }
        }
        return str;
    }

    @Test
    public void basicTests() {
        // doTest("abracadabra", 1, "bracadabra");
//        doTest("abracadabra", 2, "brcadabra");
//        doTest("abracadabra", 6, "rcdbr");
//        doTest("abracadabra", 8, "rdr");
        doTest("abracadabra", 50, "");
    }

    private void doTest(String s, int k, String expected) {
        assertEquals(expected, solve(s, k));
    }
}
