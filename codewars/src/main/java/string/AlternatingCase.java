package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://www.codewars.com/kata/56efc695740d30f963000557/

    Swap case của chuỗi
 */
public class AlternatingCase {

    public static String toAlternativeString0(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])) {
                arr[i] = Character.toUpperCase(arr[i]);
            } else if (Character.isUpperCase(arr[i])) {
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }

    public static String toAlternativeString1(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c); // Numeric
            }
        }
        return result.toString();
    }

    public static String toAlternativeString(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (Character.getType(c)) {
                case Character.LOWERCASE_LETTER -> result.append(Character.toUpperCase(c));
                case Character.UPPERCASE_LETTER -> result.append(Character.toLowerCase(c));
                default -> result.append(c); // Numeric
            }
        }
        return result.toString();
    }

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", toAlternativeString("hello world"));
        assertEquals("hello world", toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", toAlternativeString(toAlternativeString("Hello World")));
        assertEquals("12345", toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", toAlternativeString("1a2b3c4d5e"));
        assertEquals("TOaLTERNATINGcASE", toAlternativeString("toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
