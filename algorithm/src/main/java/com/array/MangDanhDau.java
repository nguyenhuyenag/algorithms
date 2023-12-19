package com.array;

/*-
 *      'a' - 'a' = 0
 *      'b' - 'a' = 1
 *      'c' - 'a' = 2
 *    => currentChar - 'a' là chỉ số của 'a'
 */
public class MangDanhDau {

    public static void main(String[] args) {
        String inputString = "abcabcxyz"; // Chuỗi đầu vào

        // Mảng đánh dấu
        boolean[] visited = new boolean[26]; // Giả sử chỉ xét các ký tự từ 'a' đến 'z'

        System.out.println("Chuoi dau vao: " + inputString);

        // Duyệt qua chuỗi và đánh dấu các ký tự đã sử dụng
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

}
