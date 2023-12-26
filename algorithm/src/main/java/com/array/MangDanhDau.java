package com.array;

public class MangDanhDau {

    /**
     * Mảng để đếm tần suất xuất hiện của các ký tự ASCII:
     *
     * Nếu c = 'a', giá trị ASCII của 'a' là 97. Do đó, charCount[97] sẽ được tăng lên 1.
     *
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
     *      'a' - 'a' = 0
     *      'b' - 'a' = 1
     *      'c' - 'a' = 2
     *
     *    => currentChar - 'a' là chỉ số của 'a'
     */
    public void lowercase() {
        String inputString = "abcabcxyz"; // Chuỗi đầu vào
        // Mảng đánh dấu
        boolean[] visited = new boolean[26]; // Giả sử chỉ xét các ký tự từ 'a' đến 'z'
        System.out.println("Chuoi dau vao: " + inputString);
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if ('a' <= currentChar && currentChar <= 'c') {
                visited[currentChar - 'a'] = true;
            }
        }
        // In kết quả đánh dấu
        System.out.print("Cac ky tu a, b, c da duoc su dung: ");
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                char currentChar = (char) ('a' + i);
                System.out.print(currentChar + " ");
            }
        }
    }

    public static void main(String[] args) {
        ascii("(( @");
    }

}
