package test;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
 * "..... + ..............." => "...................."
 * "..... - ..."             => ".."
 * "..... - ."               => "...."
 * "..... * ..."             => "..............."
 * "..... * .."              => ".........."
 * "..... // .."             => ".."
 * "..... // ."              => "....."
 * ". // .."                 => ""
 * ".. - .."                 => ""
 */
public class MainWar {

//    public static String calc(String txt) {
//        if (txt == null || txt.isEmpty()) {
//            return "";
//        }
//        String[] parts = new String[2];
//        int left = 0, right = 0, result = 0;
//        if (txt.contains("+")) {
//            parts = txt.split("\\+");
//        } else if (txt.contains("-")) {
//            parts = txt.split("-");
//        } else if (txt.contains("*")) {
//            parts = txt.split("\\*");
//        } else if (txt.contains("//")) {
//            parts = txt.split("//");
//        }
//        if (parts.length == 2) {
//            left = parts[0].trim().length();
//            right = parts[1].trim().length();
//        }
//        if (txt.contains("+")) {
//            result = left + right;
//        } else if (txt.contains("-")) {
//            result = left - right;
//        } else if (txt.contains("*")) {
//            result = left * right;
//        } else if (txt.contains("//")) {
//            if (right == 0) {
//                return "";
//            }
//            result = left / right;
//        }
//        return ".".repeat(Math.max(0, result));
//    }

    public static String calc(String txt) {
        // Early return for empty/null input
        if (txt == null || txt.isEmpty()) {
            return "";
        }

        // Determine operator and validate expression format
        final String[] operators = {"+", "-", "*", "//"};
        String operator = null;

        for (String op : operators) {
            if (txt.contains(op)) {
                operator = op;
                break;
            }
        }

        if (operator == null) {
            return "";
        }

        // Split and validate parts
        String[] parts = txt.split(Pattern.quote(operator));
        if (parts.length != 2) {
            return "";
        }

        // Calculate lengths
        int left = parts[0].trim().length();
        int right = parts[1].trim().length();
        int result;

        // Perform operation
        switch (operator) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "//":
                if (right == 0) {
                    return "";
                }
                result = left / right;
                break;
            default:
                return "";
        }

        // Handle negative result
        if (result <= 0) {
            return "";
        }

        // Build output string efficiently
        return ".".repeat(result);
    }

    @Test
    public void test() {
        assertEquals("....................", calc("..... + ..............."));
        assertEquals("..", calc("..... - ..."));
    }

}
