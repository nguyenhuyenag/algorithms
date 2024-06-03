package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Chủ đề: Two pointer

    https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

    Cho 2 chuỗi s1 và s2. Trả về số ký tự tối thiểu cần được thêm vào cuối của s1 để
    s2 trở thành một dãy con của s1.

    Chuỗi s2 là con của s1 nếu ta có một vài ký tự trong s1 (không thay đổi thứ tự) sẽ thu được s2.
 */
public class AppendCharactersToStringToMakeSubsequence {

    /*
        Ta sẽ đếm số ký tự của s1 có trong s2, giống với bài toán tìm phần từ chung của chuỗi.
     */
    public int appendCharacters(String s1, String s2) {
        int p1 = 0, p2 = 0;
        // Duyệt 2 chuỗi
        while (p1 < s1.length() && p2 < s2.length()) {
            // Tìm thấy vị trí mà ký tự khớp nhau thì tăng con trỏ của s2
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p2++;
            }
            // Con trỏ của s1 vẫn tăng bình thường
            p1++;
        }
        // Số ký tự cần thêm vào s1 là số ký tự còn lại trong s2 chưa được duyệt qua = s2.length() - p2.
        return s2.length() - p2;
    }

    @Test
    public void test() {
        assertEquals(4, appendCharacters("coaching", "coding"));
        // assertEquals(0, appendCharacters("abcde", "a"));
    }

}
