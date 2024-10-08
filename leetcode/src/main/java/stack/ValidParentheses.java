package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Xem thêm: Codewar > ValidBraces.java
 */
public class ValidParentheses {

    // s1, s2 tạo thành 1 cặp ngoặc đúng
    public boolean pair(char s1, char s2) {
        return (s1 == '(' && s2 == ')') ||
                (s1 == '{' && s2 == '}') ||
                (s1 == '[' && s2 == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // Nếu đỉnh stack và c tạo thành 1 cặp thì gỡ nó khỏi stack
            if (!stack.isEmpty() && pair(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertEquals(true, isValid("()"));
        assertEquals(false, isValid("(]"));
        assertEquals(true, isValid("()[]{}"));
    }

    // '(', ')', '{', '}', '[', ']'
//    public boolean isValid_OK(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (c == '[') {
//                stack.push(']');
//            } else {
//                if (stack.isEmpty() || stack.pop() != c) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

}
