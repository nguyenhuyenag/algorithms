package string;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/valid-word/

    A word is considered valid if:
        It contains a minimum of 3 characters.
        It contains only digits (0-9), and English letters (uppercase and lowercase).
        It includes at least one vowel.
        It includes at least one consonant.
 */
public class ValidWord {

    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    char lowerC = Character.toLowerCase(c);
                    if (vowels.contains(lowerC)) {
                        hasVowel = true;
                    } else {
                        hasConsonant = true;
                    }
                }
            } else {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }

    @Test
    public void test() {
        assertEquals(true, isValid("234Adas"));
        assertEquals(false, isValid("b3"));
        assertEquals(true, isValid("aya"));
        assertEquals(false, isValid("Ya$"));
    }

}
