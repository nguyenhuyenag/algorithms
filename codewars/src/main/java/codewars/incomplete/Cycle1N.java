package codewars.incomplete;

import java.math.BigDecimal;

// https://www.codewars.com/kata/5a057ec846d843c81a0000ad/
public class Cycle1N {

    public static void main(String[] args) {
        int numerator = 1;
        int denominator = 11;

        double result = (double) numerator / denominator;

        System.out.println("Kết quả: " + result);

        String repeatedSubstring = findRepeatedSubstring("0.0909");

        if (repeatedSubstring != null) {
            System.out.println("Khoảng lặp: " + repeatedSubstring);
        } else {
            System.out.println("Không tìm thấy khoảng lặp.");
        }
    }

    public static String findRepeatedSubstring(String input) {
        int length = input.length();
        for (int i = 1; i <= length / 2; i++) {
            String substring = input.substring(0, i);
            int repeatedLength = length / i;
            String repeatedString = repeat(substring, repeatedLength);

            if (input.startsWith(repeatedString)) {
                return substring;
            }
        }
        return null;
    }

    public static String repeat(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }

}
