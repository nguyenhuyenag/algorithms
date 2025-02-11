package string;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 *
 * Cho chuỗi chứa số và ký tự lẫn lộn. Kiểm tra xem các số có tạo thành 1 dãy tăng dần không?
 */
public class CheckIfNumberAreAscendingInASentence {

    public boolean areNumbersAscending(String s) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        int previous = Integer.MIN_VALUE;
        while (matcher.find()) {
            int current = Integer.parseInt(matcher.group());
            if (previous >= current) return false;
            previous = current;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertEquals(false, areNumbersAscending("hello world 5 x 5"));
    }

}
