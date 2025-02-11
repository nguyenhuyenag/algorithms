package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 */
public class RemoveAllOccurrencesOfAString {

    public String removeOccurrences(String s, String part) {
        int idx;
        StringBuilder builder = new StringBuilder(s);
        while ((idx = builder.indexOf(part)) != -1) {
            builder.delete(idx, idx + part.length()); // Xóa phần tử được tìm thấy
        }
        return builder.toString();
    }

    @Test
    public void test1() {
        assertEquals("dab", removeOccurrences("daabcbaabcbc", "abc"));
    }

    @Test
    public void test2() {
        assertEquals("ab", removeOccurrences("axxxxyyyyb", "xy"));
    }

}
