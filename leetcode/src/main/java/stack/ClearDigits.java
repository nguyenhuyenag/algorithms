package stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/clear-digits/description/

    Cho chuỗi s. Thực hiện hành động dau

        - Xóa ký tự số đầu tiên và chữ cái bên phải nó.

    Trả về chuỗi s cuối cùng.
 */
public class ClearDigits {

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Xóa ký tự không phải số gần nhất bên trái (nếu có)
                while (!(stack.isEmpty() || !Character.isLetter(stack.peek()))) {
                    stack.pop();
                    break;  // Chỉ xóa một ký tự duy nhất
                }
            } else {
                stack.push(c);
            }
        }

        // Ghép stack thành chuỗi kết quả
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    @Test
    public void test1() {
        assertEquals("abc", clearDigits("abc"));
    }

    @Test
    public void test2() {
        assertEquals("", clearDigits("ab23"));
    }

}
