package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Tìm chuỗi chung dài nhất (bắt đầu từ 0-index) của các phần tử
 */
public class LongestCommonPrefix {

    // Kiểm tra các phần tử có chứa cùng một ký tự ở vị trí i hay không
    public boolean sameCharacterAtIndex(String[] arr, int i) {
        char firstChar = arr[0].charAt(i);
        for (String s : arr) {
            // Nếu vượt mảng hoặc vị trí i của a0 khác với vị trí i của những phần từ khác -> false
            if (i >= s.length() || firstChar != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] arr) {
        int pointer = 0;
        String firstStr = arr[0];
        List<String> result = new ArrayList<>();
        // Con trỏ đi từ 0, ở mỗi vị trí kiểm tra xem các phần tử có cùng ký tự không
        while (sameCharacterAtIndex(arr, pointer)) {
            char ch = firstStr.charAt(pointer);
            result.add(String.valueOf(ch));
            pointer++;
        }
        return String.join("", result);
    }

    @Test
    public void test() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}
