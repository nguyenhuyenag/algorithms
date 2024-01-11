package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*-
 * https://leetcode.com/problems/add-binary/
 *
 * Nguyên tắc cơ bản để cộng hai số nhị phân như sau:
 *
 *      0 + 0 = 0
 *      1 + 0 = 1
 *      0 + 1 = 1
 *      1 + 1 = 10 (ghi 0 nhớ 1)
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = 1; i <= maxLen; i++) {
            int x = i <= a.length() ? Character.getNumericValue(a.charAt(a.length() - i)) : 0;
            int y = i <= b.length() ? Character.getNumericValue(b.charAt(b.length() - i)) : 0;
            int sum = x + y + carry;
            ans.append(sum % 2); // Append the sum digit (0 or 1)
            carry = sum / 2;     // Carry over to the next digit
        }
        if (carry > 0) {
            ans.append(carry); // Append the final carry if any
        }
        return ans.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals("100", addBinary("1", "11"));
        assertEquals("10101", addBinary("1010", "1011"));
    }

}
