package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/split-a-string-in-balanced-strings/

    Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

    Given a balanced string s, split it into some number of substrings such that:

        - Each substring is balanced.

    Return the maximum number of balanced strings you can obtain.
 */
public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        assertEquals(4, balancedStringSplit("RLRRLLRLRL"));
        assertEquals(2, balancedStringSplit("RLRRRLLRLL"));
    }

}
