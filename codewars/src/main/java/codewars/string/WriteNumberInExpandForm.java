package codewars.string;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5842df8ccbd22792a4000245/
 *
 *      12     ->  "10 + 2"
 *      42     ->  "40 + 2"
 *      70304  ->  "70000 + 300 + 4"
 */
public class WriteNumberInExpandForm {

    public static String expandedForm(int n) {
        LinkedList<String> expandedList = new LinkedList<>();
        int multiplier = 1;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit > 0) {
                expandedList.push(String.valueOf(lastDigit * multiplier));
            }
            n /= 10;
            multiplier *= 10;
        }
        return String.join(" + ", expandedList);
    }

    @Test
    public void test() {
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
    }

}
