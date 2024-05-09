package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/
 *
 * Giả sử a = 1, b = 2,... In ra từ có giá trị lớn nhất trong chuỗi
 *
 *      "man i need a taxi up to ubud" => taxi
 */
public class HighestScoringWord {

    public int calScore(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (c - 'a') + 1; // 'a' = 97
        }
        return sum;
    }

    public String high(String s) {
        int hightScore = 0;
        String maxWord = "";

        for (String word : s.split(" ")) {
            int value = calScore(word);
            if (value > hightScore) {
                hightScore = value;
                maxWord = word;
            }
        }

        return maxWord;
    }

    @Test
    public void sampleTests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", high("aa b"));
        assertEquals("b", high("b aa"));
        assertEquals("bb", high("bb d"));
        assertEquals("d", high("d bb"));
        assertEquals("aaa", high("aaa b"));
    }

}
