package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/permutation-in-string/

    Cho 2 chuỗi s1, s2. Trả về true nếu s2 chứa một hoán vị của s1, ngược lại trả về false.

    In other words, return true if one of s1's permutations is the substring of s2.
 */
public class MainLeet {

//    public boolean checkInclusion(String s1, String s2) {
//        return true;
//    }

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder builder = new StringBuilder();
                while (stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
                int i = 0;
                while (i < builder.length()) {
                    stack.push(builder.charAt(i++));
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals(true, checkInclusion("ab", "eidbaooo"));
    }

}
