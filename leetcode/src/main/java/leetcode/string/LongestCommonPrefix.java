package leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    /**
     * Kiểm tra xem tất cả các chuỗi trong mảng arr có chứa cùng một ký tự ở vị trí cụ thể i không
     */
    public boolean allStringsEqualAtIndex(String[] arr, int i) {
        char firstChar = arr[0].charAt(i);
        for (String s : arr) {
            // Nếu chỉ số vượt mảng hoặc vị trí index của a0 khác với ai -> false
            if (i >= s.length() || firstChar != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] arr) {
        int pointer = 0;
        List<String> list = new ArrayList<>();
        while (allStringsEqualAtIndex(arr, pointer)) {
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
