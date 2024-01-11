package codewars.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/517abf86da9663f1d2000003/
 *
 * Chuyển chuỗi về dạng camel
 */
public class ConvertStringToCamelCase {

    public static String toCamelCase(String input) {
        boolean capitalize = false;
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '-' || c == '_') {
                capitalize = true;
            } else {
                builder.append(capitalize ? Character.toUpperCase(c) : c);
                capitalize = false;
            }
        }
        return builder.toString();
    }

    @Test
    public void testSomeDashLowerStart() {
        Map<String, String> map = new HashMap<>();
        map.put("theStealthWarrior", "the-Stealth-Warrior");
        map.put("theStealthWarrior", "the_Stealth_Warrior");
        map.put("theStealthWarrior", "the_stealth_warrior");
        map.forEach((k, v) -> {
            assertEquals(k, ConvertStringToCamelCase.toCamelCase(v));
        });
    }

}
