package test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainLeet {

    public static int numberOfPairs(String[] gloves) {
        Map<String, Integer> counter = new HashMap<>();
        for (String color : gloves) {
            counter.put(color, counter.getOrDefault(color, 0) + 1);
        }
        int count = 0;
        for (int v : counter.values()) {
            if (v >= 2) {
                count += (v / 2);
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(0, numberOfPairs(new String[]{}));
        assertEquals(1, numberOfPairs(new String[]{"red", "red"}));
        assertEquals(0, numberOfPairs(new String[]{"red", "green", "blue"}));
        assertEquals(3, numberOfPairs(new String[]{"gray", "black", "purple", "purple", "gray", "black"}));
        assertEquals(4, numberOfPairs(new String[]{"red", "green", "blue", "blue", "red", "green", "red", "red", "red"}));
        // System.out.println(2 / 2);
    }

}
