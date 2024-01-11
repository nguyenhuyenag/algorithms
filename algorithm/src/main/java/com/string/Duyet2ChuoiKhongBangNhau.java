package com.string;

public class Duyet2ChuoiKhongBangNhau {

    public static void main(String[] args) {
        String a = "ab";
        String b = "1234";
        int maxLength = Math.max(a.length(), b.length());
        // i = 1 vì phần tử cuối chuỗi len - 1
        for (int i = 1; i <= maxLength; i++) {
            char charA = (i <= a.length()) ? a.charAt(a.length() - i) : 'x';
            char charB = (i <= b.length()) ? b.charAt(b.length() - i) : 'x';
            System.out.println(charA + "," + charB);
        }
    }

}
