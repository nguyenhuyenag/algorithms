package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/56a5d994ac971f1ac500003e/
 *
 * Cho mảng string và số nguyên k. Tạo mảng mới bằng cách ghép k chuỗi liên tiếp.
 * Trả về chuỗi dài nhất
 *
 *      arr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2
 *
 *      new = ["treefoling", "folingtrashy",...]
 */
public class ConsecutiveStrings {

    public String longestConsec(String[] arr, int k) {
        String max = "";
        int len = arr.length;
        if (k <= 0 || k > len) return "";
        for (int i = 0; i <= len - k; i++) {
            String str = String.join("", Arrays.copyOfRange(arr, i, i + k));
            if (str.length() > max.length()) {
                max = str;
            }
        }
        return max;
    }

    public void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        // System.out.println("longestConsec Fixed Tests");
        testing(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(longestConsec(new String[]{}, 3), "");
        testing(longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }

//    @Test
//    public void test() {
//        int k = 2;
//        String[] arr = {"tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"};
//        // longestConsec(arr, k);
//        Assertions.assertEquals("folingtrashy", longestConsec(arr, k));
//    }

}
