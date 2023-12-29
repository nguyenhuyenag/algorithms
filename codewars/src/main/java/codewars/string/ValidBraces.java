package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5277c8a221e209d3f6000b56/
 *
 * Validate dấu ngoặc
 *
 *      "(){}[]"   =>  True
 *      "([{}])"   =>  True
 *      "(}"       =>  False
 *      "[(])"     =>  False
 *      "[({})](]" =>  False
 *
 * Xem thêm 'ValidParentheses.java'
 */
public class ValidBraces {

    public boolean isValid0(String input) {
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            input = input.replace("{}", "")
                        .replace("[]", "")
                        .replace("()", "");
        }
        return input.isEmpty();
    }

    public boolean isClosing(char open, char close) {
        return (open == '{' && close == '}') //
                || (open == '(' && close == ')') //
                || (open == '[' && close == ']');
    }

    /**
     * - Nếu phẩn tử ở đỉnh stack hợp với c thành một cặp thì xóa phần tử ở đỉnh. Ngược lại đẩy c vào stack
     *
     * - pop(): Lấy ra và XÓA phần tử ở đỉnh
     *
     * - peek(): Lấy ra nhưng KHÔNG XÓA phần tử ở đỉnh
     */
    public boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();
        for (char c : braces.toCharArray())
            // stack phải khác rỗng thì peek() mới không null
            if (!stack.isEmpty() && isClosing(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        return stack.isEmpty();
    }

    @Test
    public void testValid() {
        // assertEquals(true, isValid("()"));
        // assertEquals(true, isValid("[]"));
        // assertEquals(true, isValid("([{}])"));
        // assertEquals(true, isValid("{}({})[]"));
        // assertEquals(false, isValid("[(])"));
        assertEquals(false, isValid("(})"));
    }
}
