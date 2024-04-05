package com.string;

public class StringTools {

    /*
      + Kiểm tra 2 ký tự 'một viết hoa, một viết thường' của cùng một ký tự hay không.

      + Ký tự 'a' có giá trị ASCII là 97 và ký tự 'A' có giá trị ASCII là 65, khi tính sự chênh
        lệch giữa chúng (97 - 65) hoặc (65 - 97) đều bằng 32.
     */
    public static boolean isGoodPair(char c1, char c2) {
        return Math.abs(c1 - c2) == 32;
    }

    public static boolean isGoodPair2(char c1, char c2) {
        return c1 != c2 && Character.toUpperCase(c1) == Character.toLowerCase(c2);
        // return c1 != c2 && (c1 == Character.toUpperCase(c2) || c1 == Character.toLowerCase(c2));
    }

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
        // System.out.println(removeLeadingZeros("0"));
        char c1 = 'a', c2 = 'A';
        System.out.println(isGoodPair(c1, c2));
        System.out.println(isGoodPair2(c1, c2));
    }


}
