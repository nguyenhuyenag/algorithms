package leetcode;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Chuỗi s được gọi là 'good' nếu s[i] và s[i+1] giống nhau và cùng là ký tự hoa hoặc ký tự thường.
    Cho chuỗi s, xóa các ký tự không thỏa mãn để chuỗi s là 'good'.

    Ví dụ:
        leEeetcode -> l(eE)eetcode -> leetcode
        abBAcC -> (ab)BAcC -> (BA)cC -> (cC) -> ""
 */
public class MainLeet {

//    public static boolean isGoodPair(char c1, char c2) {
//        return (Character.isLowerCase(c1) && Character.toUpperCase(c1) == c2) ||
//                (Character.isUpperCase(c1) && Character.toLowerCase(c1) == c2);
//    }

    public static boolean isNotGoodPair(char c1, char c2) {
        return c1 != c2 && (c1 == Character.toUpperCase(c2) || c1 == Character.toLowerCase(c2));
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isNotGoodPair(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        stack.forEach(result::append);
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("leetcode", makeGood("leEeetcode"));
        assertEquals("", makeGood("abBAcC"));
    }

}
