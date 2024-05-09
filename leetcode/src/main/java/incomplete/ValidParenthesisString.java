package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/valid-parenthesis-string/

    Cho chuỗi chỉ chứa '(', ')', '*'. Ký tự '*' có thể xem là '(', ')' hoặc chính nó.

    Kiểm tra chuỗi có hợp lệ không
 */
public class ValidParenthesisString {

    public boolean isPair(char c1, char c2) {
        return c1 == '(' && c2 == ')' || c1 == '(' && c2 == '*' || c1 == '*' && c2 == ')';
    }

    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Đẩy chỉ số của dấu '(' vào stack
            if (ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                // Đẩy chỉ số của dấu '*' vào stack
                star.push(i);
            } else {
                /* - Nếu gặp dấu ')' thì:
                 * + Nếu có dấu '(' trong stack open thì loại bỏ nó
                 * + Ngược lại, nếu có dấu '*' trong stack star thì loại bỏ nó
                 * + Nếu cả hai stack đều rỗng thì trả về false
                 */
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else return false;
            }
        }

        // Xử lý những dấu '(' còn lại trong stack open
        /* So sánh vị trí của '*' và '('
         * Nếu vị trí của '*' lớn hơn '('
         * thì có nghĩa là chúng ta có thể chuyển một số '*' thành ')'.
         */
        while (!open.isEmpty() && !star.isEmpty() && star.peek() > open.peek()) {
            open.pop();
            star.pop();
        }

        // Nếu sau khi xử lý mà stack open vẫn còn phần tử thì trả về false
        return open.isEmpty();
    }

    @Test
    public void test() {
        // assertEquals(true, checkValidString("()"));
        assertEquals(true, checkValidString("(*)"));
        // assertEquals(true, checkValidString("((*)"));
    }

}
