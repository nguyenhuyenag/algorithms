package incomplete;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    https://leetcode.com/problems/count-vowel-strings-in-ranges/

    Cho mảng các chuỗi words, và mảng queries = [[a,b], [x, y],...] đại diện cho các khoản.

    Với mỗi queries[i] ví dụ [a,b] hãy đếm số lưỡng chuỗi bắt đầu và kết thúc là nguyên âm.

    Nguyên âm: 'a', 'e', 'i', 'o', 'u'

    Example 1:
        Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
        Output: [2,3,0]
        Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
        The answer to the query [0,2] is 2 (strings "aba" and "ece").
        to query [1,4] is 3 (strings "ece", "aa", "e").
        to query [1,1] is 0.
        We return [2,3,0].
 */
public class CountVowelStringInRanges {

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Time Limit Exceeded
    public int[] vowelStrings_TLE(String[] words, int[][] queries) {
        int k = 0;
        int[] result = new int[queries.length];
        for (int[] q : queries) {
            int count = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                String word = words[i];
                if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                    count++;
                }
            }
            result[k++] = count;
        }
        return result;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        boolean[] mark = new boolean[words.length];
        for (int i = 0; i < mark.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                mark[i] = true;
            }
        }
        int k = 0;
        for (int[] q : queries) {
            int count = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                if (mark[i]) {
                    count++;
                }
            }
            result[k++] = count;
        }
        return result;
    }

    @Test
    public void test1() {
        int[] actual = vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"},
                new int[][]{{0, 2}, {1, 4}, {1, 1}});
        assertArrayEquals(new int[]{2, 3, 0}, actual);
    }

    @Disabled
    @Test
    public void test2() {
        int[] actual = vowelStrings(new String[]{"a", "e", "i"},
                new int[][]{{0, 2}, {0, 1}, {2, 2}});
        assertArrayEquals(new int[]{3, 2, 1}, actual);
    }

}
