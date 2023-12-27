package codewars;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/java
 */
public class WarMain {

    public static String pigIt(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");
        for (String word : words) {
            StringBuilder modifiedWord = new StringBuilder();
            char firstChar = word.charAt(0);
            // Check if the first character is a letter
            if (Character.isLetter(firstChar)) {
                modifiedWord.append(word, 1, word.length())
                            .append(firstChar)
                            .append("ay");
            } else {
                modifiedWord.append(word);
            }
            result.append(modifiedWord).append(" ");
        }
        return result.toString().trim();
    }

    @Test
    public void doTest() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
    }

}
