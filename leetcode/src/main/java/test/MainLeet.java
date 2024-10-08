package test;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 */
public class MainLeet {

    public int minLength_OK(String s) {
        int i;
        StringBuilder builder = new StringBuilder(s);
        while ((i = builder.indexOf("AB")) != -1 || (i = builder.indexOf("CD")) != -1) {
            builder.delete(i, i + 2); // Remove "AB"
        }
        return builder.length();
    }

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == 'A' && ch == 'B') {
                    stack.pop();
                } else if (stack.peek() == 'C' && ch == 'D') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }

    @Test
    public void test() {
        assertEquals(2, minLength("ABFCACDB"));
        // assertEquals(5, minLength("ACBBD"));
    }

}
