package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    /**
     * Kiểm tra xem tất cả các chuỗi trong mảng arr có chứa cùng một ký tự ở vị trí cụ thể index không
     */
    private static boolean sameCharacterAtIndex(String[] arr, int index) {
        String firstStr = arr[0];
        for (String s : arr) {
            // Nếu chỉ số vượt mảng hoặc vị trí index của a0 khác với ai -> false
            if (index >= s.length() || firstStr.charAt(index) != s.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] arr) {
        int pointer = 0;
        List<String> list = new ArrayList<>();
        while (sameCharacterAtIndex(arr, pointer)) {
            char currentChar = arr[0].charAt(pointer);
            list.add(String.valueOf(currentChar));
            pointer++;
        }
        return String.join("", list);
    }

    @Test
    public void test() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

}
