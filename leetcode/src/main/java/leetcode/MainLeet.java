package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

//    @Test
//    public void test() {
//    }


    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int num = 0;
        char operator = '+';

        for (int i = 0; i <= s.length(); i++) {
            char c = (i == s.length()) ? '+' : s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (isOperator(c)) {
                switch (operator) {
                    case '+' -> st.push(num);
                    case '-' -> st.push(-num);
                    case '*' -> st.push(st.pop() * num);
                    case '/' -> st.push(st.pop() / num);
                }
                num = 0;
                operator = c;
            }
        }

        int ans = 0;

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


}
