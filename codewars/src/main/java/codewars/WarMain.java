package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class WarMain {

    public static int findShort(String s) {
        String[] words = s.split(" ");
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            min = Math.min(min, word.length());
        }
        return min;
    }

    @Test
    public void doTest() {
        assertEquals(2, findShort("Let's travel abroad shall we"));
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"));
    }

}
