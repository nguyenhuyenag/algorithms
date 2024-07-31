package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://www.codewars.com/kata/5656b6906de340bd1b0000ac/

    Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string,
    the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.

        Examples:
        a = "xyaabbbccccdefww"
        b = "xxxxyyyyabklmopq"
        longest(a, b) -> "abcdefklmopqwxy"

        a = "abcdefghijklmnopqrstuvwxyz"
        longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */
public class TwoToOne {

    public static String longest(String s1, String s2) {
        StringBuilder builder = new StringBuilder();
        int[] mark = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            mark[c - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            mark[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (mark[i] > 0) {
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }

    @Test
    public void test1() {
        String s1 = "xyaabbbccccdefww";
        String s2 = "xxxxyyyyabklmopq";
        // longest(a, b) -> "abcdefklmopqwxy"
        assertEquals("abcdefklmopqwxy", longest(s1, s2));
    }

}
