package codewars.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/55c04b4cc56a697bb0000048/
 *
 * Cho 2 chuỗi s1, s2. Trả về true nếu chuỗi s1 chứa s2 (không kể thứ tự)
 */
public class Scramblies {

    public static boolean scramble(String s1, String s2) {
        int[] charCount = new int[26];
        // Count s1
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }
        // Count s2
        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false; // Exit early if a character count becomes negative
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, scramble("rkqodlw", "world"));
        assertEquals(true, scramble("cedewaraaossoqqyt", "codewars"));
        assertEquals(false, scramble("katas", "steak"));
    }


}
