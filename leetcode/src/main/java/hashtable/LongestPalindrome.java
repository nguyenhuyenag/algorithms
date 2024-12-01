package hashtable;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/longest-palindrome/

    Cho chuỗi s chỉ chứa các chữ cái. Tìm độ dài lớn nhất của chuỗi đối xứng có thể tạo từ chuỗi s.

    Ví dụ: s = 'abccccdd' -> Chuỗi dài nhất có thể tạo là 'dccaccd' -> kết quả = 7
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        // Đếm số lần xuất hiện của các ký tự
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Nếu số lần xuất hiện là chẵn thì chắc chắn sẽ tạo được thành chuỗi đối xứng,
        // nên ta chỉ cần đếm số lần xuất hiện lẻ.
        int oddCount = 0;
        for (int count : frequency.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // Nếu chỉ có 1 lần xuất hiện lẻ thì chuỗi s là chuỗi đối xứng nếu ta đặt ký tự lẻ đó ở giữa.
        // Ngược lại thì chỉ cần trừ đi hết số lẻ và + 1 (vì số lẽ là 1 sẽ quay lại trường hợp trên).
        return oddCount > 1 ? s.length() - oddCount + 1 : s.length();
    }

    @Test
    public void test() {
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(1, longestPalindrome("a"));
    }

}
