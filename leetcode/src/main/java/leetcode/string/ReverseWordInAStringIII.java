package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * "Let's take LeetCode contest" -> "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordInAStringIII {

    public static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public static String reverseWords(String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = reverse(arr[i]);
        }
        return String.join(" ", arr);
    }

    @Test
    public void test() {
        String s = "Let's take LeetCode contest";
        // System.out.println(reverseWords(s));
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords(s));
    }

    public String reverseWords2(String str) {
        StringBuilder builder = new StringBuilder();
        for (String s : str.split(" ")) {
            builder.append(reverse(s)).append(" ");
        }
        return builder.toString().trim();
    }

}
