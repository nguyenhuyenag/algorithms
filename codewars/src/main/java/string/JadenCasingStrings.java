package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * https://www.codewars.com/kata/5390bac347d09b7da40006f6/
 *
 * Viết hoa chữ cái đầu tiên:
 *
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 *
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 *
 * Xem thêm: ConvertStringToCamelCase
 */
public class JadenCasingStrings {

    public String toJadenCase(String str) {
        if (str == null || str.isEmpty()) {
            return "";  // Return empty string for null or empty input
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
        return new String(arr);
    }

    @Test
    public void test() {
        assertNull(toJadenCase(""));
        assertNull(toJadenCase(null));
        assertEquals("Most Trees Are Blue", toJadenCase("most trees are blue"));
    }

}
