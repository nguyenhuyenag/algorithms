package test;

import org.junit.jupiter.api.Test;

import java.util.Set;

/*
 */
public class MainWar {

    public static String shortcut(String input) {
        Set<Character> vowels = Set.of('a', 'e', 'o', 'u', 'i');
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!vowels.contains(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Test
    public void test() {

    }

}
