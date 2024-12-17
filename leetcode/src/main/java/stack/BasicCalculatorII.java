package stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

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

    @Test
    public void test() {
        assertEquals(6, calculate("1+2+3"));
        assertEquals(1, calculate("3/2"));
    }

}
