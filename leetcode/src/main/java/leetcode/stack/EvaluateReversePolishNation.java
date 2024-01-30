package leetcode.stack;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * ["2","1","+","3","*"] = ((2 + 1) * 3) = 9
 *
 * - Duyệt mảng và chèn từng phần tử (số) vào stack, nếu gặp toán tử '+', '-', '*', '/'
 * thì lấy 2 số ở đỉnh stack thực hiện pphép tính
 *
 * - Hai trường hợp đặc biệt là '-' và '/':
 *
 * Stack = [a,b], đặt n1 = stack.pop(), n2 = stack.pop()
 * a - b = n2 - n1
 * a / b = n2 / n1
 */
public class EvaluateReversePolishNation {

//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for (String token : tokens) {
//            switch (token) {
//                case "+" -> stack.push(stack.pop() + stack.pop());
//                case "-" -> stack.push(-stack.pop() + stack.pop());
//                case "*" -> stack.push(stack.pop() * stack.pop());
//                case "/" -> {
//                    int n1 = stack.pop(), n2 = stack.pop();
//                    stack.push(n2 / n1);
//                }
//                default -> stack.push(Integer.parseInt(token));
//            }
//        }
//        return stack.pop();
//    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 - n1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    @Test
    public void test() {
        assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
