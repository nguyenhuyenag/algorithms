package incomplete;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Cho chuỗi ngẫu nhiên có chứa các dấu ngoặc '(', ')'. Xóa (ít nhất) các dấu
 * ngoặc dư để chuỗi cuối cùng chỉ chứa các dấu ngoặc hợp lệ.
 *
 * Chuỗi rỗng luôn là chuỗi đúng.
 */
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        // Lưu index những dấu '(', ')' không đúng
        Stack<Integer> stack = new Stack<>();
        Set<Integer> invalidIndex = new HashSet<>();

        // Bước 1: Tìm các dấu ngoặc không hợp lệ và index của chúng
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                // Có đóng nhưng không có mở
                if (stack.isEmpty()) {
                    invalidIndex.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Đánh dấu các dấu ngoặc mở không có cặp là không hợp lệ
        invalidIndex.addAll(stack);

        // Bước 2: Xây dựng chuỗi kết quả, bỏ qua các chỉ mục không hợp lệ
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        // assertEquals("lee(t(c)o)de", minRemoveToMakeValid("lee(t(c)o)de)"));
        // assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
        assertEquals("", minRemoveToMakeValid("))(("));
    }

}
