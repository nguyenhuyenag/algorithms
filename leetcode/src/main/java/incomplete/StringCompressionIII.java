package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/string-compression-iii/
 */
public class StringCompressionIII {

    public String compressedString_OK(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= word.length(); i++) {
            // Nếu là ký tự cuối hoặc ký tự tiếp theo khác với ký tự hiện tại
            if (i == word.length() || word.charAt(i) != word.charAt(i - 1)) {
                char currentChar = word.charAt(i - 1);
                // Chia nhóm 9 khi count > 9
                while (count > 9) {
                    comp.append(9).append(currentChar);
                    count -= 9;
                }
                // Thêm phần còn lại (<= 9)
                if (count > 0) {
                    comp.append(count).append(currentChar);
                }
                count = 1;
            } else {
                count++;
            }
        }
        return comp.toString();
    }

    public String compressedString_OK_2(String word) {
        StringBuilder comp = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c != stack.peek()) {
                    comp.append(stack.size()).append(stack.peek());
                    stack.clear();
                    stack.push(c);
                } else {
                    if (stack.size() == 9) {
                        comp.append(9).append(c);
                        stack.clear();
                        stack.push(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        comp.append(stack.size()).append(stack.peek());
        return comp.toString();
    }

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            // Nếu stack != null và ký tự hiện tại khác với đỉnh stack
            if (!stack.isEmpty() && c != stack.peek()) {
                // => Tạo kết quả từ stack hiện tại và xóa stack
                comp.append(stack.size()).append(stack.peek());
                stack.clear();
            } else if (stack.size() == 9) {
                // ngược lai nếu độ dài của stack = 9 thì tạo kết quả và xóa stack
                comp.append(9).append(c);
                stack.clear();
            }
            // đẩy ký hiện hiện tại vào stack
            stack.push(c);
        }

        if (!stack.isEmpty()) {
            comp.append(stack.size()).append(stack.peek());
        }

        return comp.toString();
    }


    @Test
    public void test() {
        // assertEquals("1a1b1c1d1e", compressedString("abcde")); // Pass
        // assertEquals("9a5a2b", compressedString("aaaaaaaaaaaaaabb")); // Pass
        assertEquals("1m1r1m", compressedString("mrm")); // Fail
    }

}
