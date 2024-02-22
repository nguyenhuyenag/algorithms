package com.string;

public class StringTools {

    // Xóa số 0 ở đầu số dạng chuỗi
    public static String removeLeadingZeros(String input) {
        int index = 0;
        int len = input.length();
        while (index < len && input.charAt(index) == '0') {
            index++;
        }
        return index == len ? "0" : input.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(removeLeadingZeros("0"));
    }


}
