package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainLeet {

    public int myAtoi(String s) {
        s = s.trim();
        String strNum = s.startsWith("-") ? s.substring(1) : s ;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strNum.length(); i++) {
            if (Character.isDigit(strNum.charAt(i))) {
                ans.append(strNum.charAt(i));
            } else {
                break;
            }
        }
        if (s.startsWith("-")) {
            ans.insert(0, "-");
        }
        if (ans.isEmpty()) {
            ans.append("0");
        }
        return Integer.parseInt(ans.toString());
    }

    @Test
    public void testSomething() {
        assertEquals(123, myAtoi("123"));
        assertEquals(-123, myAtoi("-123"));
        assertEquals(4193, myAtoi("4193 with words"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(-42, myAtoi("      -42"));
    }

}
