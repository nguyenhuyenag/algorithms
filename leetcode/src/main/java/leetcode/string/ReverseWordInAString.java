package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * "the sky is blue" -> "blue is sky the"
 */
public class ReverseWordInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int l = 0, r = words.length - 1;
        while (l < r) {
            String t = words[l];
            words[l++] = words[r];
            words[r--] = t;
        }
        return String.join(" ", words);
    }

    @Test
    public void test() {
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
        assertEquals("world hello", reverseWords("  hello world  "));
        assertEquals("example good a", reverseWords("a good   example"));
    }

}
