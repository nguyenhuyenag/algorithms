package leetcode.queue;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharacterByFrequency {

    public String frequencySort(String input) {
        // Đếm ký tự
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        // Hàng đợi ưu tiên theo value
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue()
        );
        pq.addAll(charCount.entrySet());
        // Ghép chuỗi thành kết quả
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            result.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("eert", frequencySort("tree"));
        assertEquals("eeeeoollvtdc", frequencySort("loveleetcode"));
    }

}
