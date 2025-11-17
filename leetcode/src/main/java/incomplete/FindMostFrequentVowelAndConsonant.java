package incomplete;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
 *
 * Cho một chuỗi s gồm các chữ cái tiếng Anh viết thường ('a' -> 'z'). Nhiệm vụ của bạn là:
 *   - Tìm nguyên âm ('a', 'e', 'i', 'o', 'u') xuất hiện với tần suất lớn nhất.
 *   - Tìm phụ âm (tất cả các chữ cái còn lại, ngoại trừ nguyên âm) xuất hiện với tần suất lớn nhất.
 *   => Trả về tổng của hai tần suất đó.
 */
public class FindMostFrequentVowelAndConsonant {

    public int maxFreqSum(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Counter
        char[] marks = new char[26];
        for (char c : s.toCharArray()) {
            marks[c - 'a']++;
        }

        // Tìm max vowel frequency, max consonant frequency
        int maxVowel = 0;
        int maxConsonant = 0;

        for (int i = 0; i < 26; i++) {
            int freq = marks[i];
            if (freq == 0) continue;

            char ch = (char) ('a' + i);
            if (vowels.contains(ch)) {
                maxVowel = Math.max(maxVowel, freq);
            } else {
                maxConsonant = Math.max(maxConsonant, freq);
            }
        }

        return maxVowel + maxConsonant;
    }

    @Test
    public void test() {
        assertEquals(6, maxFreqSum("successes"));
        assertEquals(3, maxFreqSum("aeiaeia"));
    }

}
