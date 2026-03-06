package array;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

    Cho một chuỗi nh phân không có số 0 ở đầu. Trả về TRUE nếu có nhiều nhất một đoạn liên
    tiếp các số 1, ngược lại trả về FALSE.

    Ví dụ:

        s	        Kết quả	    Giải thích
        111000	    true	    chỉ có 1 đoạn 111
        110011	    false	    có 2 đoạn 11
        1	        true	    một đoạn 1
        101	        false	    hai đoạn 1
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment_Error(String s) {
        if (s.length() <= 2) return true;
        int count = 0;
        // Duyệt từ 0 -> n - 1 và kiểm tra s[i], s[i+1]
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
                count++;
            }
            if (count > 1) return false;
        }
        return count == 1;
    }

    public boolean checkOnesSegment_Error2(String s) {
        // Vì chuỗi luôn bắt đầu là '1' nên luôn tồn tại 1 đoạn liên tiếp.
        int count = 1;
        Stack<Character> stack = new Stack<>();
        stack.push('1'); // Do chuỗi luôn bắt đầu từ '1'
        // Duyệt từ 1 -> n.
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                count++;
            } else {

            }
        }
        return count == 1;
    }

    /*
        - Chỉ cần kiểm tra chuỗi có chứa "01" hay không. Vì

            + "01" nghĩa là kết thúc đoạn 1.

            + Nếu sau đó lại có 1 → sẽ có đoạn 1 thứ hai
     */
    public boolean checkOnesSegment_OK(String s) {
        return !s.contains("01");
    }

    public boolean checkOnesSegment(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            /*
                > Nếu 2 ký tự liên tiếp khác nhau -> có sự chuyển đoạn.
                - Có thể là '01' hoặc '10'.
                - Vì chuỗi luôn có dạng '1xxxx' tức là chỉ có 1 lần chuyển '1' -> '0'
                - Nếu có thêm '0' -> '1' -> chắc chắn có thêm đoạn '1' thứ hai.
             */
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
                // Nếu có nhiều hơn 1 lần chuyển đoạn -> có ít nhất 2 đoạn '1'
                if (count > 1) return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Object[][] testCases = { //
                {"110011", false}, //
                {"110", true}, //
                {"1001", false}, //
                {"1", true}, //
                {"10", true}, //
                {"111", true}, //
                {"1000", true} //
        };

        for (Object[] tc : testCases) {
            String s = (String) tc[0];
            boolean expected = (boolean) tc[1];
            assertEquals(expected, checkOnesSegment(s));
        }
    }

}
