package com.array;

public class MangDanhDauLetter {

    public static void main(String[] args) {
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

}
