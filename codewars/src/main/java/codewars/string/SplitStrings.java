package codewars.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cắt chuỗi thành chuỗi con có độ dài 2, nếu chuỗi con thiếu thì thêm ký tự `_`
 */
public class SplitStrings {

    public static String[] solution(String str) {
        str = str.length() % 2 == 0 ? str : str + "_";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i += 2) {
            list.add(str.substring(i, i + 2));
        }
        return list.toArray(String[]::new);
    }

    @Test
    public void testEvenString() {
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, solution("abcdef"));
        assertArrayEquals(new String[]{"He", "ll", "oW", "or", "ld"}, solution("HelloWorld"));
    }

    @Test
    public void testOddString() {
        assertArrayEquals(new String[]{"ab", "cd", "e_"}, solution("abcde"));
        assertArrayEquals(new String[]{"Lo", "ve", "Pi", "zz", "a_"}, solution("LovePizza"));
    }

}
