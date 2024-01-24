package leetcode.string;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/faulty-keyboard/
 *
 * Gõ lần lượt các ký tự, khi gặp 'i' thì đảo ngược kết quả.
 */
public class FaultyKeyboard {

    public String finalString(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("rtsng", finalString("string"));
        // assertEquals("ponter", finalString("poiinter"));
    }

//    public static void main(String[] args) {
//    }

}
