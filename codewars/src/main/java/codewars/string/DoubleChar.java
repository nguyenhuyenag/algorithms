package codewars.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/56b1f01c247c01db92000076/
 */
public class DoubleChar {

    public static String pad(char c, int n) {
        return String.valueOf(c).repeat(n);
    }

    public static String doubleChar0(String input) {
        String[] words = input.split("");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            words[i] = pad(c, 2);
        }
        return String.join("", words);
    }

    public static String doubleChar(String input) {
        String[] words = input.split("");
        StringBuilder ans = new StringBuilder();
        for (String s : words) {
            ans.append(s.repeat(2));
        }
        return ans.toString();
    }

    @Test
    public void test() {
        assertEquals("SSttrriinngg", doubleChar("String"));
        assertEquals("11223344!!__  ", doubleChar("1234!_ "));
        assertEquals("HHeelllloo  WWoorrlldd", doubleChar("Hello World"));
    }

}
