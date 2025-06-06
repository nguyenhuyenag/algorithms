package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainWar {

    public static boolean isValid_1(char[] walk) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char direction : walk) {
            counter.put(direction, counter.getOrDefault(direction, 0) + 1);
        }
        return walk.length == 10 &&
                counter.getOrDefault('n', 0).equals(counter.getOrDefault('s', 0)) &&
                counter.getOrDefault('e', 0).equals(counter.getOrDefault('w', 0));
    }

    public static boolean isValid(char[] walk) {
        int nsCount = 0, ewCount = 0;
        for (char direction : walk) {
            switch (direction) {
                case 'n':
                    nsCount++;
                    break;
                case 's':
                    nsCount--;
                    break;
                case 'e':
                    ewCount++;
                    break;
                case 'w':
                    ewCount--;
                    break;
            }
        }
        return walk.length == 10 && nsCount == 0 && ewCount == 0;
    }

    private static void doTest(char[] input, boolean expected) {
        String message = "for input = " + Arrays.toString(input);
        boolean actual = isValid(input);
        assertEquals(expected, actual, message);
    }

    @Test
    void falseWalkTooShort() {
        doTest(new char[]{'n'}, false);
        doTest(new char[]{'n', 's'}, false);
    }

    @Test
    void falseWalkTooLong() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'}, false);
    }

    @Test
    void falseDoesNotLoopBackToStart() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n'}, false);
        doTest(new char[]{'e', 'e', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, false);
        doTest(new char[]{'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'}, false);
        doTest(new char[]{'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w'}, false);
        doTest(new char[]{'s', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e'}, false);
        doTest(new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'}, false);
    }

    @Test
    void trueIsValid10MinutesWalk() {
        doTest(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}, true);
        doTest(new char[]{'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'}, true);
        doTest(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'}, true);
    }

}
