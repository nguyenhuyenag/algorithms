package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/multiply-strings/description/
 *
 *              2 7
 *          x   3 6
 *       -----------
 *            1 6 2
 *            8 1
 *       -----------
 *            9 7 2
 */
public class MultiplyStrings {

    public static String leftPad(String str, int maxLen) {
        int numZeros = Math.max(0, maxLen - str.length());
        return "0".repeat(numZeros) + str;
    }

    public static int[] toStringArray(String numStr) {
        return numStr.chars().map(Character::getNumericValue).toArray();
    }

    /**
     * Cộng 2 số
     */
    public static String add(String x, String y) {
        int maxLen = Math.max(x.length(), y.length());

        int[] A = toStringArray(leftPad(x, maxLen));
        int[] B = toStringArray(leftPad(y, maxLen));

        int carry = 0; // Số nhớ
        StringBuilder ans = new StringBuilder();

        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = (A[i] + B[i]) + carry;
            carry = sum / 10;       // sum < 10 thì carry = 0, sum >= 10 thì carry = 1
            ans.append(sum % 10);   // Chèn 9 vào
        }

        // Nếu ở cuối vòng lặp mà vẫn còn nhớ
        if (carry > 0) {
            ans.append(carry);
        }

        // Xóa số 0 vô nghĩa ở đầu số 0123 -> 123
        String result = ans.reverse().toString().replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }

    /**
     * Nhận 2 số
     */
    public String multiply(String s1, String s2) {
        int p = 0;
        List<String> listNum = new ArrayList<>();
        for (int i = s1.length() - 1; i >= 0; i--) {
            int rem = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = s2.length() - 1; j >= 0; j--) {
                int n1 = Character.getNumericValue(s1.charAt(i));
                int n2 = Character.getNumericValue(s2.charAt(j));
                // System.out.print(n1 + "x" + n2 + " ");
                int prod = n1 * n2 + rem;
                rem = prod / 10;
                builder.append(prod % 10);
            }
            if (rem > 0) {
                builder.append(rem);
            }
            listNum.add(builder.reverse().append("0".repeat(p++)).toString());
            // System.out.println();
        }
        // System.out.println(listNum);
        String result = "0";
        for (String v : listNum) {
            result = add(result, v);
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals("972", multiply("36", "27"));
        assertEquals("56088", multiply("123", "456"));
    }

}
