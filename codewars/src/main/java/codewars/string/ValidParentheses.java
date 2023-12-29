package codewars.string;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * https://www.codewars.com/kata/valid-parentheses-1
 *
 * Validate dấu ngoặc tròn. Ví dụ
 *      "()"              =>  true
 *      ")(()))"          =>  false
 *      "("               =>  false
 *      "(())((()())())"  =>  true
 */
public class ValidParentheses {

    public static boolean validParentheses0(String input) {
        while (input.contains("()")) {
            input = input.replace("()", "");
        }
        return input.isEmpty();
    }

    public static boolean validParentheses(String input) {
        StringBuilder builder = new StringBuilder(input);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '(') {
                int idx = builder.indexOf(")", i);
                if (idx != -1) {
                    builder.setCharAt(i, ' ');
                    builder.setCharAt(idx, ' ');
                }
            }
        }
        return builder.toString().trim().length() == 0;
    }

//    @Test
//    @DisplayName("Should return true for valid parentheses")
//    public void validCases() {
//        assertEquals(true, validParentheses("()"));
//        assertEquals(true, validParentheses("((()))"));
//        assertEquals(true, validParentheses("()()()"));
//        assertEquals(true, validParentheses("(()())()"));
//        assertEquals(true, validParentheses("()(())((()))(())()"));
//    }

    @Test
    @Disabled("Ignore this test!")
    @DisplayName("Should return true for valid parentheses")
    void validCases() {
        runTest(true, "()");
        runTest(true, "((()))");
        runTest(true, "()()()");
        runTest(true, "(()())()");
        runTest(true, "()(())((()))(())()");
    }

    @Test
    @DisplayName("Should return false for invalid parentheses")
    void invalidCases() {
        runTest(false, ")(");
        runTest(false, "()()(");
        runTest(false, "((())");
        runTest(false, "())(()");
        runTest(false, ")()");
        runTest(false, ")");
    }

    @Test
    @DisplayName("Should return true for empty strings")
    void emptyString() {
        runTest(true, "");
    }

    private void runTest(boolean expected, String input) {
        assertEquals(expected, validParentheses(input), "Test failed for input \"" + input + "\"");
    }


}
