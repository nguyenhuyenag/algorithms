package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

    - Cho số nguyên n. Liên tục thay chuỗi bằng dãy tổng 2 chữ số kề nhau (mod 10) cho đến
    khi còn 2 chữ số, rồi kiểm tra xem chúng có bằng nhau không.

    Ví dụ:
        Giả sử s = "1234"

        Bước 1:
            (1 + 2) % 10 = 3
            (2 + 3) % 10 = 5
            (3 + 4) % 10 = 7
            → s = "357"

        Bước 2:
            (3 + 5) % 10 = 8
            (5 + 7) % 10 = 2
            → s = "82"

        Chuỗi còn 2 chữ số là 8 và 2, không bằng nhau → trả về false.
 */
public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public StringBuilder action(StringBuilder s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            int sum = (s.charAt(i) - '0') + (s.charAt(i + 1) - '0');
            res.append(sum % 10);
        }
        return res;
    }

    public boolean hasSameDigits_OK1(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 2) {
            sb = action(sb);
        }
        return sb.charAt(0) == sb.charAt(1);
    }

    public boolean hasSameDigits_OK2(String s) {
        char[] arr = s.toCharArray();

        while (arr.length > 2) {
            int len = arr.length;
            char[] next = new char[len - 1];
            for (int i = 0; i < len - 1; i++) {
                int sum = (arr[i] - '0') + (arr[i + 1] - '0');
                next[i] = (char) (sum % 10 + '0');
            }
            arr = next;
        }

        return arr[0] == arr[1];
    }

    public boolean hasSameDigits(String s) {
        int len = s.length();

        // Convert to array of int
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Action
        while (len > 2) {
            int[] next = new int[len - 1]; // Mảng mới sẽ ít hơn 1 phần tử so với mảng trước.
            for (int i = 0; i < len - 1; i++) {
                next[i] = (digits[i] + digits[i + 1]) % 10;
            }
            digits = next;
            len--;
        }

        return digits[0] == digits[1];
    }

    @Test
    public void test() {
        assertEquals(true, hasSameDigits("3902"));
        assertEquals(false, hasSameDigits("34789"));
        assertEquals(false, hasSameDigits("1234"));
    }

}
