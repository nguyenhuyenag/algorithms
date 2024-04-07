package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MainLeet {

//    public String minRemoveToMakeValid(String s) {
//        Stack<Integer> stack = new Stack<>();
//        Set<Integer> invalidIndices = new HashSet<>();
//
//        // Bước 1: Tìm các dấu ngoặc không hợp lệ và lưu trữ chỉ mục của chúng
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                stack.push(i);
//            } else if (c == ')') {
//                if (stack.isEmpty()) {
//                    invalidIndices.add(i);
//                } else {
//                    stack.pop();
//                }
//            }
//        }
//
//        // Đánh dấu các dấu ngoặc mở không có cặp là không hợp lệ
//        while (!stack.isEmpty()) {
//            invalidIndices.add(stack.pop());
//        }
//
//        // Bước 2: Xây dựng chuỗi kết quả, bỏ qua các chỉ mục không hợp lệ
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (!invalidIndices.contains(i)) {
//                result.append(s.charAt(i));
//            }
//        }
//
//        return result.toString();
//    }
//
//    @Test
//    public void test() {
//        // assertEquals("lee(t(c)o)de", minRemoveToMakeValid("lee(t(c)o)de)"));
//        // assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
//        assertEquals("", minRemoveToMakeValid("))(("));
//    }

}
