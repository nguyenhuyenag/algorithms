package com.string;

import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

// Đếm các ký tự cùng xuất hiện ở cả 2 chuỗi
public class CharCommon {

    public static void usingMap() {
        String s1 = "hello";
        String s2 = "world";

        // Convert the characters of s2 to a HashMap for fast lookups
        HashMap<Character, Boolean> charMap2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            charMap2.put(c, true);
        }

        // StringBuilder to store the result
        StringBuilder commonCharacters = new StringBuilder();

        // Iterate through the characters of s1
        for (char c : s1.toCharArray()) {
            // Check if the character is present in the HashMap
            if (charMap2.containsKey(c)) {
                commonCharacters.append(c);
            }
        }

        // Print the common characters
        System.out.println("Common characters are: " + commonCharacters.toString());
    }

    public static void usingMarkArray() {
        String s1 = "hello";
        String s2 = "world";

        // Assuming ASCII characters, create a boolean array
        boolean[] charMark = new boolean[256];

        // Mark the presence of characters from s2 in the boolean array
        for (char c : s2.toCharArray()) {
            charMark[c] = true;
        }

        // StringBuilder to store the result
        StringBuilder commonCharacters = new StringBuilder();

        // Iterate through the characters of s1
        for (char c : s1.toCharArray()) {
            // Check if the character is present in the boolean array
            if (charMark[c]) {
                commonCharacters.append(c);
            }
        }

        // Print the common characters
        System.out.println("Common characters are: " + commonCharacters.toString());
    }

    public static void main(String[] args) {
        usingMap();
        // usingMarkArray();
    }

}
