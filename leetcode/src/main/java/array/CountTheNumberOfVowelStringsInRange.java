package array;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/

    Cho chuỗi words là hai số nguyên l, r. Một chuỗi gọi là vowel-string nếu ký
    tự đầu và cuối của nó đều là nguyên âm.

    Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].
 */
public class CountTheNumberOfVowelStringsInRange {

    public int vowelStrings(String[] words, int left, int right) {
        final Set<Character> vowels = Set.of('a', 'e', 'o', 'u', 'i');
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            if (vowels.contains(start) && vowels.contains(end)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        assertEquals(3, vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4));
    }

}
