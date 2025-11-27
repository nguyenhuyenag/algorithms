package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/check-if-a-string-can-break-another-string/

    Cho 2 chuỗi s1, s2. Kiểm tra xem có một hoán vị nào của s1 trội hơn của s2 hay không.
    Chuỗi x trội hơn y nếu tại mọi vị trí i, ký tự x[i] >= y[i].
 */
public class CheckIfAStringCanBreakAnotherString {

    public boolean checkIfCanBreak(String s1, String s2) {
        // Sắp xếp lại s1, s2
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        boolean aBreak = true; // Biến kiểm tra nếu a trội
        boolean bBreak = true; // Biến kiểm tra nếu b trội
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) aBreak = false;
            if (b[i] < a[i]) bBreak = false;
            // Nếu cả 2 đều false thì dừng, không cần duyệt tiếp
            if (!aBreak && !bBreak) return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, checkIfCanBreak("abc", "xya"));
        assertEquals(false, checkIfCanBreak("abe", "acd"));
    }

}
