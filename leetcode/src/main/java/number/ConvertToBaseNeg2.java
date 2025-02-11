package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/convert-to-base-2/
 */
public class ConvertToBaseNeg2 {

    // Xóa số 0 ở đầu số dạng chuỗi
    public static String removeLeadingZeros(StringBuilder num) {
        int len = num.length();
        int i = 0;
        while (i < len && num.charAt(i) == '0') {
            i++;
        }
        return i == len ? "0" : num.substring(i);
    }

    /*
        Trong quá trình chuyển đổi số từ hệ thập phân sang một hệ cơ số âm, chúng ta
        cần đảm bảo rằng các chữ số của kết quả luôn nằm trong khoảng từ [0, |base| - 1]
     */
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        int base = -2;
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int rem = n % base;
            n /= base;
            if (rem < 0) {
                rem -= base;
                n++;
            }
            builder.append(rem);
        }
        return removeLeadingZeros(builder.reverse());
    }

    @Test
    public void test() {
        assertEquals("110", baseNeg2(2));
    }

}
