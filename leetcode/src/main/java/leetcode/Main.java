package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/
 */
public class Main {

    @Test
    public void doTest() {
        // assertEquals(13, countHomogenous("abbcccaa"));
        String input = "aaazaaaaaaabbbbbbbcccccddddeeeff";
        int[] charCount = new int[26];
        for (char currentChar : input.toCharArray()) {
            charCount[currentChar - 'a'] += 1;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                System.out.println((char) (i + 'a') + "->" + charCount[i]);
            }
        }
        System.out.println(Arrays.toString(charCount));
    }

}
