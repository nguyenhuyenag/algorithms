package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/maximum-score-after-splitting-a-string/

    Cho chuỗi nhị phân, cắt chuỗi làm 2 phần sao cho tổng lớn nhất.

    Example 1: Input: s = "011101",  Output: 5
        Explanation:
        All possible ways of splitting s into two non-empty substrings are:
        left = "0" and right = "11101", score = 1 + 4 = 5
        left = "01" and right = "1101", score = 1 + 3 = 4
        left = "011" and right = "101", score = 1 + 2 = 3
        left = "0111" and right = "01", score = 1 + 1 = 2
        left = "01110" and right = "1", score = 2 + 1 = 3

 */
public class MaximumScoreAfterSplittingAString {

    public int maxScore(String s) {
        int max = 0;
        int leftZeros = 0, rightOnes = 0;

        // Count the total number of 1's in the string initially
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rightOnes++;
            }
        }

        // Iterate through the string to split it into two parts
        for (int i = 0; i < s.length() - 1; i++) { // Avoid splitting at the very end
            if (s.charAt(i) == '0') {
                leftZeros++; // Increment count of 0's on the left
            } else {
                rightOnes--; // Decrement count of 1's on the right
            }

            // Update max score
            max = Math.max(max, leftZeros + rightOnes);
        }

        return max;
    }

    @Test
    public void test() {
        assertEquals(5, maxScore("011101"));
    }

}
