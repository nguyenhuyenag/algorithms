package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/remove-k-digits/

    Cho số nguyên n và số nguyên k. Xóa k chữ số trong n sao cho
    kết quả cuối cùng là nhỏ nhất
 */
public class RemoveKDigits {

    public static String removeLeadingZeros(StringBuilder num) {
        int i = 0;
        int len = num.length();
        while (i < len && num.charAt(i) == '0') {
            i++;
        }
        return i == len ? "0" : num.substring(i);
    }

    public String removeKdigits_TLE(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
            k--;
        }
        return removeLeadingZeros(sb);
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        stack.forEach(result::append);
        return removeLeadingZeros(result);
    }

    @Test
    public void test() {
        assertEquals("1219", removeKdigits("1432219", 3));
        assertEquals("200", removeKdigits("10200", 1));
    }

}
