package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/51e056fe544cf36c410000fb/
 */
public class MainWar {

    public static String stringMerge(String s1, String s2, char letter) {
        // Find the index of the given letter in both words
        int index1 = s1.indexOf(letter);
        int index2 = s2.indexOf(letter);

        // Merge the words based on the position of the letter
        return s1.substring(0, index1 + 1) + s2.substring(index2 + 1);
    }

    @Test
    public void test() {
        assertEquals("held", stringMerge("hello", "world", 'l'));
        assertEquals("codinywhere", stringMerge("coding", "anywhere", 'n'));
        assertEquals("jasamson", stringMerge("jason", "samson", 's'));
        assertEquals("wondeople", stringMerge("wonderful", "people", 'e'));
    }


}
