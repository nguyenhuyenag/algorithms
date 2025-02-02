package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
public class ReverseSubstringBetweenParentheses {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c=='(') {

            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("dcba", reverseParentheses("(abcd)"));
    }

}
