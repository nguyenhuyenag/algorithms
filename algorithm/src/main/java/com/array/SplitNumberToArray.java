package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * "3322251" -> ["33", "222", "5", "1"]
 *
 * Xem thêm: leetcode > CountAndSay.java
 */
public class SplitNumberToArray {

    public static void main(String[] args) {
        String s = "2111";

        List<String> result = new ArrayList<>();

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                result.add(repeatChar(s.charAt(i - 1), count));
                count = 1;
            }
        }
        result.add(repeatChar(s.charAt(s.length() - 1), count));

        System.out.println("result = " + result);
    }

    private static String repeatChar(char c, int count) {
        return String.valueOf(c).repeat(count);
    }

}
