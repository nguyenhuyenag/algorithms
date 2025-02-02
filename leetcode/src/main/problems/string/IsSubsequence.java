package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Chủ đề: Two pointer

    https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

    Kiểm tra chuỗi con:

        Chuỗi s1 là con của s2 nếu ta xóa một vài ký tự trong s2 (không thay đổi thứ tự) sẽ thu được s1.

    Xem thêm: leetcode > AppendCharactersToStringToMakeSubsequence.java
 */
public class IsSubsequence {

    public boolean isSubsequence(String s1, String s2) {
        int p1 = 0, p2 = 0;
        // Duyệt 2 chuỗi bằng 2 con trỏ và dừng nếu có 1 con trỏ đi đến cuối
        while (p1 < s1.length() && p2 < s2.length()) {
            // Tìm thấy ký tự khớp 2 chuỗi
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        // Nếu p1 = len(s1) tức tất cả ký tự trong s1 đều được tìm thấy theo thứ tự trong s2 -> true
        return p1 == s1.length();
    }

    @Test
    public void test() {
        assertEquals(true, isSubsequence("abc", "ahbgdc"));
        assertEquals(false, isSubsequence("axc", "ahbgdc"));
    }

}
