package com.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SplitString {

    public static void insertSpaceBetweenDifferentChars0(String input) {
        StringBuilder result = new StringBuilder();
        int last = input.length() - 1;
        for (int i = 0; i < last; i++) {
            result.append(input.charAt(i));
            if (input.charAt(i) != input.charAt(i + 1)) {
                result.append(" ");
            }
        }
        result.append(input.charAt(last));
        System.out.println(result.toString());
    }

    public static List<String> splitStringOnDifference(String input) {
        List<String> result = new ArrayList<>();
        StringBuilder currentGroup = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            currentGroup.append(input.charAt(i));
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                result.add(currentGroup.toString());
                currentGroup.setLength(0);
            }
        }
        System.out.println("result = " + result);
        return result;
    }

    public static List<String> splitString(String text) {
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                // System.out.println("char=" + text.charAt(start) + ", " + text.substring(start, i));
                String s = text.substring(start, i);
                System.out.println(s.length() + "" + s.charAt(0));
                result.add(text.substring(start, i));
                start = i;
            }
        }
        // Add the last substring, if any
        result.add(text.substring(start));

        String s = text.substring(start);
        System.out.println(s.length() + "" + s.charAt(0));

        System.out.println("result = " + result);

        return result;
    }

    @Test
    public void doTest() {
        String n = "3322251";
        // AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "one");
        splitString(n);
    }

}
