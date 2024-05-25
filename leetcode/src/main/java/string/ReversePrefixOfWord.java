package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/reverse-prefix-of-word/

    Cho chuỗi s và ký tự ch, đảo chuỗi trong đoạn 0 -> vị trí của ch.
    Nếu ch không tồn tại trong s thì không làm gì.
 */
public class ReversePrefixOfWord {

    public String reversePrefix_OK(String word, char ch) {
        int l = 0;
        int r = word.indexOf(ch);
        char[] chars = word.toCharArray();
        while (l <= r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }
        return new String(chars);
    }

    public String reversePrefix_OK2(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int index = word.indexOf(ch);
        for (int i = index; i >= 0; i--) {
            result.append(word.charAt(i));
        }
        for (int i = index + 1; i < word.length(); i++) {
            result.append(word.charAt(i));
        }
        return result.toString();
    }

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder result = new StringBuilder(word.substring(0, index + 1));
        return result.reverse().append(word.substring(index + 1)).toString();
    }

    @Test
    public void test() {
        assertEquals("dcbaefd", reversePrefix("abcdefd", 'd'));
        assertEquals("zxyxxe", reversePrefix("xyxzxe", 'z'));
    }

//    public String reversePrefix(String word, char ch) {
//        int index = word.indexOf(ch);
//        if (index != -1) {
//            char[] chars = word.toCharArray();
//            int l = 0, r = index;
//            while (l <= r) {
//                char t = chars[l];
//                chars[l] = chars[r];
//                chars[r] = t;
//                l++;
//                r--;
//            }
//            return new String(chars);
//        }
//        return word;
//    }

}
