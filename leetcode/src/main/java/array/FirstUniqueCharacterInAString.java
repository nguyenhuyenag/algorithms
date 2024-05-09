package array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Tìm ký tự duy nhất đầu tiên trong chuỗi
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar0(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1; // No unique character found
    }

    public int firstUniqChar1(String s) {
        for (char c : s.toCharArray()) {
            int index = s.indexOf(c);
            if (index == s.lastIndexOf(c)) {
                return index;
            }
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
        assertEquals(-1, firstUniqChar("aabb"));
    }

}
