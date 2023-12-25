package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Cho 2 chuỗi, s, t. Thực hiện thao tác xóa ký tự khoảng trắng và ký tự trước khoảng trắng.
 * Sao sánh 2 chuỗi sau khi thực hiện thao tác trên (xem '#' là khoảng trắng)
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private static String processString0(String inputStr) {
        StringBuilder result = new StringBuilder();
        for (char c : inputStr.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }
        return result.toString();
    }

    private static String processString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    @Test
    public void doTest() {
        assertEquals(true, backspaceCompare("ab#c", "ad#c"));
        assertEquals(true, backspaceCompare("ab##", "c#d#"));
        assertEquals(false, backspaceCompare("a#c", "b"));
    }

}
