package leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * Đảo k ký tự đầu tiên của chuỗi
 *
 * abcde, k = 2    ->      bacde
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // k = 2: 0, 2, 4, 6,...
        for (int i = 0; i < n; i += 2 * k) {
            int l = i, r = Math.min(i + (k - 1), n - 1); // Vì đếm từ 0-index
            while (l < r) {
                char t = chars[l];
                chars[l++] = chars[r];
                chars[r--] = t;
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        // assertEquals("bacd", reverseStr("abcd", 2));
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

}
