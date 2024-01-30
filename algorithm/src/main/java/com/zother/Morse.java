package com.zother;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/54b724efac3d5402db00065e/
 *
 * https://www.codewars.com/kata/54b724efac3d5402db00065e
 */
public class Morse {

    private static final Map<Character, String> morseEncodeMap = new HashMap<>();
    private static final Map<String, Character> morseDecodeMap = new HashMap<>();

    static {
        morseEncodeMap.put('A', ".-");
        morseEncodeMap.put('B', "-...");
        morseEncodeMap.put('C', "-.-.");
        morseEncodeMap.put('D', "-..");
        morseEncodeMap.put('E', ".");
        morseEncodeMap.put('F', "..-.");
        morseEncodeMap.put('G', "--.");
        morseEncodeMap.put('H', "....");
        morseEncodeMap.put('I', "..");
        morseEncodeMap.put('J', ".---");
        morseEncodeMap.put('K', "-.-");
        morseEncodeMap.put('L', ".-..");
        morseEncodeMap.put('M', "--");
        morseEncodeMap.put('N', "-.");
        morseEncodeMap.put('O', "---");
        morseEncodeMap.put('P', ".--.");
        morseEncodeMap.put('Q', "--.-");
        morseEncodeMap.put('R', ".-.");
        morseEncodeMap.put('S', "...");
        morseEncodeMap.put('T', "-");
        morseEncodeMap.put('U', "..-");
        morseEncodeMap.put('V', "...-");
        morseEncodeMap.put('W', ".--");
        morseEncodeMap.put('X', "-..-");
        morseEncodeMap.put('Y', "-.--");
        morseEncodeMap.put('Z', "--..");
        morseEncodeMap.put('1', ".----");
        morseEncodeMap.put('2', "..---");
        morseEncodeMap.put('3', "...--");
        morseEncodeMap.put('4', "....-");
        morseEncodeMap.put('5', ".....");
        morseEncodeMap.put('6', "-....");
        morseEncodeMap.put('7', "--...");
        morseEncodeMap.put('8', "---..");
        morseEncodeMap.put('9', "----.");
        morseEncodeMap.put('0', "-----");
        // You can add more characters as needed
        morseEncodeMap.forEach((k, v) -> morseDecodeMap.put(v, k));
    }

    public static String encodeToMorseCode(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (morseEncodeMap.containsKey(c)) {
                morseCode.append(morseEncodeMap.get(c)).append(" ");
            } else if (c == ' ') {
                morseCode.append(" "); // Use space for word separation
            }
        }
        return morseCode.toString().trim();
    }

    public static String endcode(String input) {
        StringJoiner morseCode = new StringJoiner(" ");
        for (char c : input.toUpperCase().toCharArray()) {
            if (morseEncodeMap.containsKey(c)) {
                morseCode.add(morseEncodeMap.get(c));
            }
        }
        System.out.println("morseCode = " + morseCode.toString());
        return morseCode.toString();
    }

    public static String decode(String morseCode) {
        return "";
    }

    @Test
    public void test() {
        String input = "ABC";
        // String morse = endcode(input);
        assertEquals(endcode(input), encodeToMorseCode(input));
    }

}
