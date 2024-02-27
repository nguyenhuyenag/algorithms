package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/smallest-good-base/
 *
 * Cho số nguyên n, tìm good-base của nó
 *
 * Good-base là base mà khi biểu diễn số n theo base, kết quả chỉ toàn số 1
 *
 * Ví dụ 13 biểu diễn ở dạng cơ số 3 là 111
 */
public class SmallestGoodBase {

    public boolean checkDigitOne(String s) {
        for (char c : s.toCharArray()) {
            if (c != '1') {
                return false;
            }
        }
        return true;
    }

    public String smallestGoodBase(String ns) {
        int n = Integer.parseInt(ns);
        for (int i = 2; i <= n; i++) {
            String val = Integer.toString(n, i);
            // System.out.println("i = " + i + ", " + "val = " + val);
            if (checkDigitOne(val)) {
                return Integer.toString(i);
            }
        }
        return "";
    }

    @Test
    public void test() {
        // assertEquals("3", smallestGoodBase("13"));
        assertEquals("8", smallestGoodBase("4681"));
    }
}
