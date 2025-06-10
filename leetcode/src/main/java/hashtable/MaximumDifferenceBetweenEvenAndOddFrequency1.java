package hashtable;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*-
    https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/

    Cho chuỗi s, giả sử xi là số lần xuất hiện lẽ và yi là số lần xuất hiện chẵn của
    các ký tự trong s.

    Tìm hiệu lớn nhất của xi - yi.

    Sol: Đếm số lần xuất hiện của các ký tự trong chuỗi s, sau đó tìm số lẽ lớn nhất
    và số chẵn nhỏ nhất. Trả về hiệu của chúng.
 */
public class MaximumDifferenceBetweenEvenAndOddFrequency1 {

    // Dùng HashMap
    public int maxDifference_OK(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        int maxOdd = 0;
        int minEven = s.length() + 1; // Gán minEven lớn hơn độ dài chuỗi (hoặc max integer)
        for (int x : counter.values()) {
            if (x % 2 != 0) { // Tìm số lẽ lớn nhất
                maxOdd = Math.max(maxOdd, x);
            } else { // Tìm số chẵn nhỏ nhất
                minEven = Math.min(minEven, x);
            }
        }
        return maxOdd - minEven;
    }

    // Dùng mảng đánh dấu
    public int maxDifference(String s) {
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        for (int count : counter) {
            if (count > 0) {
            if (count % 2 == 1) {
                maxOdd = Math.max(maxOdd, count);
            } else {
                minEven = Math.min(minEven, count);
            }
            }
        }
        return maxOdd - minEven;
    }

    @Test
    public void test() {
        assertEquals(3, maxDifference("aaaaabbc"));
        assertEquals(1, maxDifference("abcabcab"));
    }

}
