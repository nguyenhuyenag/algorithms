package map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/kth-distinct-string-in-an-array/

    Tìm ký tự duy nhất thứ k trong mảng.
 */
public class KthDistinctStringInArray {

    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> counter = new LinkedHashMap<>();
        // Count occurrences of each string
        for (String key : arr) {
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }
        // Find the k-th distinct string
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                k--;
                if (k == 0) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("a", kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
    }

}
