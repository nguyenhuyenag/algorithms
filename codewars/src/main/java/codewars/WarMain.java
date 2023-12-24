package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/
 */
public class WarMain {

    @Test
    public void toTest() {
        String s = "This is an example!";
        int poiter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                System.out.println(s.substring(poiter, i));
                poiter = i + 1;
            }
        }
        System.out.println(s.substring(poiter));
    }

}
