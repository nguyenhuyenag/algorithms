package com.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Cho mảng các chuỗi và số nguyên k. Trả về mảng k phần tử có số lần
 * xuất hiện nhiều nhất, nếu bằng nhau thì ưu tiên theo thứ tự từ điển
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>(counter.keySet());
        result.sort((w1, w2) -> {
            int p1 = counter.get(w1);
            int p2 = counter.get(w2);
            // Nếu frequency bằng nhau thì so sánh theo thứ tự từ điển
            return p1 == p2 ? w1.compareTo(w2) : p2 - p1;
        });
        return result.subList(0, k);
    }

    @Test
    public void test() {
        assertIterableEquals(List.of("i", "love"), topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        assertIterableEquals(List.of("the", "is", "sunny", "day"), topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

}
