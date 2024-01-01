package leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 * 3322251  ->  23 32 15 11   ->   23321511
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        return result;
    }

    public static String say0(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            // Ký tự hiện tại = ký tự tiếp theo và chưa phải là ký tự cuối cùng (để i + 1 tồn tại)
            if (str.charAt(i) == str.charAt(i + 1) && i < str.length() - 1) {
                count++;
            } else {
                result.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }

    public static String say(String text) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                String s = text.substring(start, i);
                ans.append(s.length()).append(s.charAt(0));
                start = i;
            }
        }
        String s = text.substring(start);
        ans.append(s.length()).append(s.charAt(0));
        return ans.toString();
    }

    @Test
    public void doTest() {
        assertEquals("1", countAndSay(1));
        assertEquals("1211", countAndSay(4));
    }

}
