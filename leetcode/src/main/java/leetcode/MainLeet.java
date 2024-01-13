package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class MainLeet {

    public int countCommonElements(char[] array1, char[] array2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            set1.add(array1[i]);
            set2.add(array2[i]);
        }
        set1.retainAll(set2);
        return set1.size();
    }

    public int minSteps(String s, String t) {
        int[] mark = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mark[s.charAt(i) - 'a']++;
            mark[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(mark).filter(v -> v > 0).sum();
    }

    @Test
    public void test() {
        assertEquals(1, minSteps("bab", "aba"));
        assertEquals(5, minSteps("leetcode", "practice"));
        assertEquals(0, minSteps("anagram", "mangaar"));
    }

}
