package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/51e056fe544cf36c410000fb/
 */
public class MainWar {

    public static List<String> top3(String s) {
        Map<String, Integer> counter = new HashMap<>();
        for (String w : s.split(" ")) {
            counter.put(w, counter.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(counter.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    @Test
    public void sampleTests() {
        assertIterableEquals(List.of("e", "ddd", "aa"), //
                top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    }

}
