package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/score-of-a-string/

    Cho chuỗi s, tính tổng giá trị:

        A = |s0 - s1| + |s1 - s2| + ...

    Trong đó si là giá trị ASCII của vị trị i.
 */
public class ScoreOfAString {

    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(13, scoreOfString("hello"));
        assertEquals(50, scoreOfString("zaz"));
    }

}
