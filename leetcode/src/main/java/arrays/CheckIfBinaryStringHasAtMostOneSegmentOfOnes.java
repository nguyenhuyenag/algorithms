package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

    Cho một chuỗi nhị phân không có số 0 ở đầu. Trả về TRUE nếu có nhiều nhất một đoạn liên
    tiếp các số 1, ngược lại trả về FALSE.

    Ví dụ:

        s	        Kết quả	    Giải thích
        111000	    true	    chỉ có 1 đoạn 111
        110011	    false	    có 2 đoạn 11
        1	        true	    một đoạn 1
        101	        false	    hai đoạn 1
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    /*
        - Chỉ cần kiểm tra chuỗi có chứa "01" hay không. Vì
            + "01" nghĩa là kết thúc đoạn 1.
            + Nếu sau đó lại có 1 → sẽ có đoạn 1 thứ hai
     */
    public boolean checkOnesSegment_OK(String s) {
        return !s.contains("01");
    }

    public boolean checkOnesSegment_OK2(String s) {
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

    /*
        - Tương tự contains()
     */
    public boolean checkOnesSegment(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
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
