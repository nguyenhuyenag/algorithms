package number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/monotone-increasing-digits/

    Một số gọi là tăng dần nếu chữ số bên trái luôn <= chữ số bên phải, ví dụ 1234.
    Cho số nguyên n, tìm số tăng dần lớn nhất <= n.
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        // 1243 -> [1, 2, 4, 3]
        char[] digits = Integer.toString(n).toCharArray();
        int size = digits.length;
        int indexToModify = size;
        // Duyệt từ phải qua trái để tìm vị trí không tăng
        for (int i = size - 1; i > 0; i--) {
            // Điểm không tăng
            if (digits[i] < digits[i - 1]) {
                indexToModify = i;
                // Giảm số phía sau xuống 1 đơn vị
                digits[i - 1]--;
            }
        }
        // Đánh dấu tất cả các số tại điểm không tăng -> cuối là '9'
        Arrays.fill(digits, indexToModify, size, '9');
        return Integer.parseInt(new String(digits));
    }

    @Test
    public void test() {
        assertEquals(9, monotoneIncreasingDigits(10));
        assertEquals(1234, monotoneIncreasingDigits(1234));
        assertEquals(1239, monotoneIncreasingDigits(1243));
        assertEquals(899999999, monotoneIncreasingDigits(963856657));
    }

//        public int monotoneIncreasingDigits(int n) {
//        // 123 -> [1, 2, 3]
//        char[] digits = Integer.toString(n).toCharArray();
//        int len = digits.length;
//        int marker = len;
//        // Duyệt từ phải qua trái để tìm vị trí đầu tiên mà các chữ số không tăng
//        // Sửa đổi các chữ số để làm cho số này tăng đơn điệu:
//        //  + Giảm chữ số gây ra lỗi đi 1.
//        //  + Thay đổi tất cả các chữ số sau đó thành 9 để tối đa hóa số nhưng vẫn đảm bảo nó tăng đơn điệu
//        for (int i = len - 1; i > 0; i--) {
//            if (digits[i] < digits[i - 1]) {
//                marker = i;
//                digits[i - 1]--;
//            }
//        }
//        Arrays.fill(digits, marker, len, '9');
//        // System.out.println(Integer.parseInt(new String(digits)));
//        return Integer.parseInt(new String(digits));
//    }

}
