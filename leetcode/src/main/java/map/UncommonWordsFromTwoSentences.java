package map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> counter = new HashMap<>();
        for (String s : s1.split(" ")) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        counter.forEach((k, v) -> {
            if (v == 1) {
                result.add(k);
            }
        });
        return result.toArray(String[]::new);
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        Map<String, Integer> counter = new HashMap<>();
        for (String s : (s1 + " " + s2).split(" ")) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        return counter.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

//    public String[] uncommonFromSentences(String s1, String s2) {
//        Set<String> set1 = new HashSet<>(Arrays.asList(s1.split(" ")));
//        Set<String> set2 = new HashSet<>(Arrays.asList(s2.split(" ")));
//
//        Set<String> temp1 = new HashSet<>(set1);
//        Set<String> temp2 = new HashSet<>(set2);
//
//        set1.removeAll(temp2); // Remove elements in set2 from set1
//        set2.removeAll(temp1); // Remove elements in set1 from set2
//
//        set1.addAll(set2);
//
//        return set1.toArray(String[]::new);
//    }


    @Test
    public void test() {
        sortAndTest(new String[]{"sweet", "sour"},
                uncommonFromSentences("this apple is sweet", "this apple is sour"));
    }

    public void sortAndTest(String[] arr1, String[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

}
