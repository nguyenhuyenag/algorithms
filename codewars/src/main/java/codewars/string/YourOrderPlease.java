package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/55c45be3b2079eccff00010f/
 */
public class YourOrderPlease {

    public static String order(String str) {
        List<String> words = Arrays.asList(str.split(" "));
        Collections.sort(words, Comparator.comparingInt(s -> {
            String intNumber = s.replaceAll("\\D", "");
            return intNumber.isEmpty() ? 0 : Integer.parseInt(intNumber);
        }));
        return String.join(" ", words);
    }

    @Test
    public void test() {
        assertEquals("Thi1s is2 3a T4est", order("is2 Thi1s T4est 3a"));
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", order("4of Fo1r pe6ople g3ood th5e the2"));
        assertEquals("", order(""));
    }

}
