package leetcode.stack;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/make-the-string-great/

    Cho chuỗi s, nếu s[i] và s[i+1] mà 'một viết hoa, một viết thường' của cùng 1 ký tự
    thì tiến hành xóa cặp ký tự này. Trả về chuỗi s sau khi xóa tất cả các cặp như trên.

    Ví dụ:
        leEeetcode -> l(eE)eetcode -> leetcode
        abBAcC -> (ab)BAcC -> (BA)cC -> (cC) -> ""
 */
public class MakeTheStringGreat {

//    public static boolean isGoodPair(char c1, char c2) {
//        return (Character.isLowerCase(c1) && Character.toUpperCase(c1) == c2) ||
//                (Character.isUpperCase(c1) && Character.toLowerCase(c1) == c2);
//    }

    public static boolean isNotGoodPair(char c1, char c2) {
        return c1 != c2 && (c1 == Character.toUpperCase(c2) || c1 == Character.toLowerCase(c2));
    }

    /*
        Nếu chuyển về mã ASCII thì c1, c2 sẽ cách nhau 32.
     */
    public static boolean isNotGoodPair2(char c1, char c2) {
        return Math.abs(c1 - c2) == 32;
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
