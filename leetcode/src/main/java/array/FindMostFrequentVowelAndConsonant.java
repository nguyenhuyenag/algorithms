package array;

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

    public int maxFreqSum_Ok(String s) {
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

    public int maxFreqSum(String s) {
        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        int[] freq = new int[26];

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        // Find max frequencies
        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f == 0) continue;

            if (isVowel[i]) {
                if (f > maxVowel) maxVowel = f;
            } else {
                if (f > maxConsonant) maxConsonant = f;
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
