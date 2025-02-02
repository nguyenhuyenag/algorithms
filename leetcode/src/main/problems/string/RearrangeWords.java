package string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 *
 * Sắp xếp lại chuỗi theo độ dài và viết hoa chữ cái đầu tiên
 */
public class RearrangeWords {

    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        // Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        String result = String.join(" ", arr);
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }

    @Test
    public void test() {
        assertEquals("Is cool leetcode", arrangeWords("Leetcode is cool"));
        assertEquals("To be or to be not", arrangeWords("To be or not to be"));
        assertEquals("On and keep calm code", arrangeWords("Keep calm and code on"));
    }

}
