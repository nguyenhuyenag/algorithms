package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 *
 * Đếm số phần tử chung chỉ xuất hiện 1 lần của 2 mảng
 */
public class CountCommonWordsWithOneOccurrence {

    public Map<String, Integer> counter(String[] words) {
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        return counter;
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> counter1 = counter(words1);
        Map<String, Integer> counter2 = counter(words2);
        int count = 0;
        // Chỉ cần duyệt trên word1 là được
        for (String word : words1) {
            int c1 = counter1.getOrDefault(word, -1);
            int c2 = counter2.getOrDefault(word, -1);
            if (c1 == 1 && c2 == 1) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"}));
    }
}
