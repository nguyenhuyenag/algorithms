package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/56a5d994ac971f1ac500003e/
 *
 * Cho mảng arr và số nguyên k, tìm phần tử có độ dài k ký tự liên tiếp
 */
public class WarMain {

    public static String longestConsec(String[] arr, int k) {
        return "";
    }

    @Test
    public void doTest() {
        test("", longestConsec(new String[]{}, 3));
        test("", longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0));
        test("", longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15));
        test("", longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2));
        test("ixoyx3452zzzzzzzzzzzz", longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3));
        test("abigailtheta", longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
        test("wlwsasphmxxowiaxujylentrklctozmymu", longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2));
        test("oocccffuucccjjjkkkjyyyeehh", longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1));
        test("wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck", longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2));
    }

    private static void test(String actual, String expected) {
        assertEquals(expected, actual);
    }

}
