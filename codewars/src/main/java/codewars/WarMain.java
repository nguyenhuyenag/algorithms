package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5839edaa6754d6fec10000a2/
 */
public class WarMain {

    public static char findMissingLetter(char[] array) {
        int[] mark = new int[26];
        return ' ';
    }

    @Test
    public void doTest() {
        assertEquals('e', findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    }

}
