package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 */
public class MainLeet {

    public int longestValidParentheses(String inputString) {
        // System.out.println("s = " + s.indexOf("()"));
        while (inputString.contains("()")) {
            inputString = inputString.replace("()", "__");
        }

        int currentSpaceLength = 0;
        int maxLength = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar == '_') {
                // Nếu là khoảng trắng, tăng độ dài của khoảng trắng hiện tại
                currentSpaceLength++;
            } else {
                // Nếu không phải khoảng trắng, kiểm tra xem độ dài hiện tại có lớn hơn max không
                if (currentSpaceLength > maxLength) {
                    maxLength = currentSpaceLength;
                }
                // Reset độ dài của khoảng trắng hiện tại
                currentSpaceLength = 0;
            }
        }

        System.out.println("s = " + inputString);

        // Kiểm tra lại sau vòng lặp cuối cùng
        if (currentSpaceLength > maxLength) {
            maxLength = currentSpaceLength;
        }

        System.out.println("Độ dài của khoảng trắng dài nhất là: " + maxLength);

        return maxLength;
    }

    @Test
    public void test() {
        // assertEquals(2, longestValidParentheses("(()"));
        // assertEquals(4, longestValidParentheses(")()())"));
        // assertEquals(2, longestValidParentheses("()(()"));
        assertEquals(6, longestValidParentheses("()(())"));
    }

}
