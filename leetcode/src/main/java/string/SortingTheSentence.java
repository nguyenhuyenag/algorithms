package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/sorting-the-sentence/
 *
 * Sort: "is2 sentence4 This1 a3" -> "This is a sentence"
 */
public class SortingTheSentence {

    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, (s1, s2) -> {
            int n1 = Integer.parseInt(s1.replaceAll("\\D", ""));
            int n2 = Integer.parseInt(s2.replaceAll("\\D", ""));
            return n1 - n2;
        });
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i].replaceAll("\\d+", "");
//        }
//        return String.join(" ", arr);
        return Arrays.stream(arr)
                .map(word -> word.replaceAll("\\d+", ""))
                .collect(Collectors.joining(" "));
    }

    @Test
    public void test() {
        assertEquals("Me Myself and I", sortSentence("Myself2 Me1 I4 and3"));
        assertEquals("This is a sentence", sortSentence("is2 sentence4 This1 a3"));
    }

}
