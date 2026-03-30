package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/

    Cho 2 chuỗi s1 và s2. Ta có thể hoán đổi ký tự tại 2 vị trí i, j bất kỳ nếu i < j và
    (j - i) chẵn.

    Trả về true nếu có thể làm cho s1 == s2, ngược lại trả về false.

    Ý tưởng:

        - Vì chỉ được swap khi j - i chẵn, tức (i,j) cùng chẵn hoặc lẽ (cùng parity).

        Vì:
            Ta có thể swap tự do trong cùng parity.
                → Thứ tự không quan trọng
                → Chỉ cần số lượng giống nhau (multiset).
 */
public class CheckIfStringsCanBeMadeEqualWithOperationsII {

    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] odd = new int[26];
        int[] even = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) { // Một đếm tăng, một đếm giảm
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        assertEquals(false, checkStrings("abe", "bea"));
        assertEquals(true, checkStrings("abcdba", "cabdab"));
    }

}
