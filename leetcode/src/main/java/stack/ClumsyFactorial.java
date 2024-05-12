package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/clumsy-factorial/
 *
 * clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 * Xem thêm bài BasicCalculatorII.java
 */
public class ClumsyFactorial {

    public void eval(Stack<Integer> stack, int num, char op) {
        switch (op) {
            case '+' -> stack.push(num);
            case '-' -> stack.push(-num);
            case '*' -> stack.push(stack.pop() * num);
            case '/' -> stack.push(stack.pop() / num);
            default -> {
            }
        }
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char op = '+'; // '+' is start operaters
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            } else if ("+-*/".indexOf(c) != -1) {
                eval(stack, num, op);
                num = 0;
                op = c;
            }
        }
        eval(stack, num, op);
        return stack.stream().mapToInt(a -> a).sum();
    }

    public int clumsy(int n) {
        char[] operators = {'*', '/', '+', '-'};
        StringBuilder result = new StringBuilder();
        int j = 0;
        for (int i = n; i >= 1; i--) {
            if (result.length() == 0) {
                result.append(i);
            } else {
                char operator = operators[j % 4]; // Sử dụng số dư của j để chọn toán tử
                result.append(operator).append(i);
                j++;
            }
        }
        // System.out.println("result = " + result.toString());
        return calculate(result.toString());
    }

    @Test
    public void test() {
        assertEquals(7, clumsy(4));
        assertEquals(12, clumsy(10));
    }

//        public int clumsy_OK(int n) {
//        LinkedList<String> listOp = new LinkedList<>();
//        Collections.addAll(listOp, "*", "/", "+", "-");
//        StringBuilder result = new StringBuilder();
//        for (int i = n; i >= 1; i--) {
//            if (result.isEmpty()) {
//                result.append(i);
//            } else {
//                String op = listOp.poll();
//                result.append(op).append(i);
//                listOp.addLast(op);
//            }
//        }
//        return calculate(result.toString());
//    }

}
