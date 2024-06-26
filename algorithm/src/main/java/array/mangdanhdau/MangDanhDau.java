package array.mangdanhdau;

/**
 * Xem thêm 'SmallPositive.java'
 *
 *      [A, B,..., Z]   =   [65, 66,..., 90]
 *
 *      [a, b,..., z]   =   [97, 98,..., 122]
 */
public class MangDanhDau {

    /*-
     * Mảng ký tự thường a-z
     *   'a' - 'a' = 0
     *   'b' - 'a' = 1
     *   'c' - 'a' = 2
     * => c - 'a' là chỉ số của 'a'
     */
    public static void lowercase() {
        String s = "abcxyz";
        boolean[] mark = new boolean[26]; // 'a' đến 'z' là 26 ký tự

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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

    /*-
     * Mảng các ký tự ASCII:
     * Nếu c = 'a', giá trị ASCII của 'a' là 97. Do đó, charCount[97] sẽ được tăng lên 1.
     * Nếu c = 'A', giá trị ASCII của 'A' là 65. Do đó, charCount[65] sẽ được tăng lên 1.
     */
    public static void ascii() {
        int[] charCount = new int[256];
        String input = "abr$63nbgd";
        for (char c : input.toCharArray()) {
            charCount[c]++;
        }
        // Hiển thị kết quả
        for (int i = 0; i < charCount.length; i++) {
            // charCount[i] = charCount['a']
            if (charCount[i] > 0) {
                System.out.println((char) i + " : " + charCount[i]);
            }
        }
    }

    public static void main(String[] args) {
        // ascii();
        lowercase();
    }

}
