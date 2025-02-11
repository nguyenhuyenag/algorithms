package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

    Example 1:

        Input: sentence = "i love eating burger", searchWord = "burg"
        Output: 4
        Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(4, isPrefixOfWord("i love eating burger", "burg"));
        assertEquals(2, isPrefixOfWord("this problem is an easy problem", "pro"));
        assertEquals(-1, isPrefixOfWord("i am tired", "you"));
    }

}
