package com.string;

public class Duyet2ChuoiKhongBangNhau {

    // Từ phải qua trái
    public static void rightToLeft() {
        String s1 = "1234";
        String s2 =   "ab";
        int maxLen = Math.max(s2.length(), s1.length());
        // i = 1 vì phần tử cuối là (len - 1)
        for (int i = 1; i <= maxLen; i++) {
            char c1 = (i <= s1.length()) ? s1.charAt(s1.length() - i) : '*';
            char c2 = (i <= s2.length()) ? s2.charAt(s2.length() - i) : '*';
            System.out.println(c1 + ", " + c2);
        }
    }

    // Từ trái qua phải
    public static void leftToRight() {
        String s1 = "1234";
        String s2 = "ab";
        int maxLen = Math.max(s1.length(), s2.length());
        for (int i = 0; i < maxLen; i++) {
            char c1 = (i < s1.length()) ? s1.charAt(i) : '*';
            char c2 = (i < s2.length()) ? s2.charAt(i) : '*';
            System.out.println(c1 + ", " + c2);
        }
    }

    public static void main(String[] args) {
        rightToLeft();
        // leftToRight();
    }

}
