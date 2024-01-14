package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5842df8ccbd22792a4000245/
 *
 * 12     ->  "10 + 2"
 * 42     ->  "40 + 2"
 * 70304  ->  "70000 + 300 + 4"
 */
public class WriteNumberInExpandForm {

    public static String expandedForm0(int n) {
        LinkedList<String> result = new LinkedList<>();
        for (int multiplier = 1; n > 0; n /= 10, multiplier *= 10) {
            int lastDigit = n % 10;
            if (lastDigit > 0) result.addFirst(lastDigit * multiplier + "");
        }
        return String.join(" + ", result);
    }

    public static String expandedForm1(int number) {
        StringJoiner result = new StringJoiner(" + ");
        String numberStr = Integer.toString(number);
        for (int i = 0; i < numberStr.length(); i++) {
            int digit = Character.getNumericValue(numberStr.charAt(i));
            if (digit > 0) {
                result.add(String.valueOf(digit * (int) Math.pow(10, numberStr.length() - 1 - i)));
            }
        }
        return result.toString();
    }

    public static String expandedForm(int n) {
        int multiplier = 1;
        LinkedList<String> result = new LinkedList<>();
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit > 0) {
                result.addFirst(String.valueOf(lastDigit * multiplier));
            }
            n /= 10;
            multiplier *= 10;
        }
        return String.join(" + ", result);
    }

    @Test
    public void test() {
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
    }

}
