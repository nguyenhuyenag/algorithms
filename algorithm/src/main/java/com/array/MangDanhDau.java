package com.array;

public class MangDanhDau {

    /*-
     * Mảng các ký tự ASCII:
     * Nếu c = 'a', giá trị ASCII của 'a' là 97. Do đó, charCount[97] sẽ được tăng lên 1.
     * Nếu c = 'A', giá trị ASCII của 'A' là 65. Do đó, charCount[65] sẽ được tăng lên 1.
     */
    public static void ascii(String input) {
        // Sử dụng
        int[] charCount = new int[256];
        for (char c : input.toCharArray()) {
            charCount[c]++;
        }
        // Hiển thị kết quả
        for (int i = 0; i < charCount.length; i++) {
            // Ví dụ: charCount[i] = charCount['a']
            if (charCount[i] > 0) {
                System.out.println((char) i + " : " + charCount[i]);
            }
        }
    }

    /*-
     * Mảng ký tự thường
     *  'a' - 'a' = 0
     *  'b' - 'a' = 1
     *  'c' - 'a' = 2
     * => currentChar - 'a' là chỉ số của 'a'
     */
    public static void lowercase() {
        String input = "abcxyz";
        boolean[] mark = new boolean[26]; // 'a' đến 'z' là 26 ký tự
        // System.out.println("Input: " + input);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) { // 'a' <= c && c <= 'c'
                mark[c - 'a'] = true;
            }
        }

        // In kết quả đánh dấu
        System.out.print("Cac ky tu da duoc su dung: ");
        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) {
                char c = (char) ('a' + i);
                System.out.print(c + " ");
            }
        }
    }

    public static void letter() {
        String input = "HelloWorld123";
        // Mảng đánh dấu cho ký tự 'a' đến 'z' và 'A' đến 'Z'
        boolean[] charUsed = new boolean[52];
        System.out.println("Chuoi dau vao: " + input);
        // Duyệt qua chuỗi và đánh dấu các ký tự đã sử dụng
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) {
                charUsed[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                charUsed[c - 'A' + 26] = true;
            }
        }

        // In kết quả đánh dấu
        System.out.print("Cac ky tu a - z, A - Z da duoc su dung: ");
        for (int i = 0; i < charUsed.length; i++) {
            if (charUsed[i]) {
                char currentChar = (i < 26) ? (char) ('a' + i) : (char) ('A' + i - 26);
                System.out.print(currentChar + " ");
            }
        }
    }

    public static void main(String[] args) {
        // ascii("(( @");
        lowercase();
    }

}
