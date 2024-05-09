package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;

/**
 * https://www.codewars.com/kata/51c8e37cee245da6b40000bd/
 */
public class StripComment {

    public static String stripComments(String text, String[] markers) {
        String[] ss = text.split("\n");
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            for (String marker : markers) {
                int index = s.indexOf(marker);
                if (index != -1) {
                    s = s.substring(0, index);

                }
            }
            s = StringUtils.stripEnd(s, null);
            ss[i] = s;
        }
        return String.join("\n", ss);
    }

    @Test
    public void stripComments() {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
        );

        assertEquals(
                "a\nc\nd",
                stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})
        );
    }
}
