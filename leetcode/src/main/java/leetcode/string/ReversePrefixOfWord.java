package leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/reverse-prefix-of-word/
 *
 * Cho chuỗi s và ký tự ch, đảo chuỗi trong đoạn 0 -> vị trí của ch.
 * Nếu ch không tồn tại trong s thì không làm gì.
 */
public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index != -1) {
            char[] chars = word.toCharArray();
            int l = 0, r = index;
            while (l <= r) {
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
                l++;
                r--;
            }
            return new String(chars);
        }
        return word;
    }

    @Test
    public void test() {
        assertEquals("dcbaefd", reversePrefix("abcdefd", 'd'));
        assertEquals("zxyxxe", reversePrefix("xyxzxe", 'z'));
    }

}
