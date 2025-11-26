package incomplete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*-
    https://leetcode.com/problems/find-the-divisibility-array-of-a-string/

    Giả sử word là số dưới dạng chuỗi và số nguyên m. Gọi div[i] là số tạo từ word[0,...,i].

    Mảng divisibility (gọi là div) của word là một mảng số nguyên có độ dài n sao cho:

        - div[i] = 1 nếu giá trị số tạo bởi chuỗi con word[0,...,i] (tức từ ký tự đầu đến ký
        tự thứ i) chia hết cho m.

        - div[i] = 0 nếu không chia hết.

    Trả về mảng divisibility của chuỗi word.

    Xem thêm: BinaryPrefixDivisibleBy5 
 */
public class FindTheDivisibilityArrayOfAString {

    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] div = new int[len];
        long rem = 0;

        for (int i = 0; i < len; i++) {
            rem = (rem * 10 + (word.charAt(i) - '0')) % m;
            div[i] = (rem == 0 ? 1 : 0);
        }

        return div;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0}, divisibilityArray("998244353", 3));
        assertArrayEquals(new int[]{0, 1, 0, 1}, divisibilityArray("1010", 10));
    }

}
