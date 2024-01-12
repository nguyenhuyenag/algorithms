package com.array.mangdanhdau;

import com.util.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class MangDanhDauKyHoaThuong {

    public static void test1() {
        // Tạo mảng đánh dấu có kích thước 52
        boolean[] charArray = new boolean[52];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Gán giá trị true cho vị trí tương ứng trong mảng
            charArray[ch - 'a'] = true;
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            // Gán giá trị true cho vị trí tương ứng trong mảng
            charArray[ch - 'A' + 26] = true;
        }
        // Dịch ngược chỉ số ra ký tự
        for (int i = 0; i < charArray.length; i++) {
            if (i < 26) {
                char ch = (char) (i + 'a');
                System.out.println(i + " : " + ch);
            } else {
                char ch = (char) (i + 'A' - 26);
                System.out.println("Index " + i + " : " + ch);
            }
        }
    }

    public static void test2() {
        String str = RandomStringUtils.randomAlphabetic(10);
        System.out.println("str = " + str);

        int[] charMap = new int[52];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {   // 97 <= c <= 122
                charMap[ch - 'a']++;        // 'b' - 'a' = 1 thì charMap[1] chính là 'b'
            } else if ('A' <= ch && ch <= 'Z') { // 65 <= c <= 90
                charMap[ch - 'A' + 26]++; // a-z là 25 nên ký tự nên các chữ hoa sẽ xếp từ 26 trở đi
            }
        }

        // In ra số lần xuất hiện của tất cả các ký tự
        for (char c = 'a'; c <= 'z'; c++) {
            if (charMap[c - 'a'] > 0)
                System.out.println("Ký tự '" + c + "' xuất hiện " + charMap[c - 'a'] + " lần");
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (charMap[c - 'A' + 26] > 0)
                System.out.println("Ký tự '" + c + "' xuất hiện " + charMap[c - 'A' + 26] + " lần");
        }
    }

    public static void main(String[] args) {
        // test1();
        test2();
    }

}
