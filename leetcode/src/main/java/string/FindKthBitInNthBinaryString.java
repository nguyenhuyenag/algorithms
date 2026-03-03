package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

    Cho hai số nguyên dương n, k. Chuỗi nhị phân S(n) được tạo như sau:

        S(1) = "0"
        S(i) = S(i - 1) + "1" + reverse(invert(S(i - 1))) với i > 1

    Trong đó:
        - Dấu + là phép nối chuỗi.
        - reverse(x) trả về chuỗi x sau khi đảo ngược thứ tự.
        - invert(x) đảo tất cả các bit trong x (0 đổi thành 1 và 1 đổi thành 0).

    Ví dụ, bốn chuỗi đầu tiên trong dãy là:

        S(1) = "0"
        S(2) = "011"
        S(3) = "0111001"
        S(4) = "011100110110001"

    -> Hãy trả về bit thứ k trong S(n).
 */
public class FindKthBitInNthBinaryString {

    // Thông thường
    public char findKthBit0(int n, int k) {
        StringBuilder[] S = new StringBuilder[n];

        S[0] = new StringBuilder("0");

        for (int i = 1; i < n; i++) {
            StringBuilder previous = S[i - 1];
            StringBuilder current = new StringBuilder();

            current.append(previous).append("1");

            // reverse + invert
            for (int j = previous.length() - 1; j >= 0; j--) {
                char bit = previous.charAt(j);
                current.append(bit == '0' ? '1' : '0');
            }

            S[i] = current;
        }

        return S[n - 1].charAt(k - 1);
    }

    // Không dùng mảng, giảm memory
    public char findKthBit1(int n, int k) {
        StringBuilder current = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            int len = current.length();
            StringBuilder next = new StringBuilder(len * 2 + 1);
            next.append(current).append('1');
            // reverse + invert
            for (int j = len - 1; j >= 0; j--) {
                next.append(current.charAt(j) == '0' ? '1' : '0');
            }
            current = next;
        }
        return current.charAt(k - 1);
    }

    // chỉ build đến đủ k. Nếu k nhỏ → dừng sớm.
    public char findKthBit(int n, int k) {
        StringBuilder current = new StringBuilder("0");
        for (int i = 1; i < n && current.length() < k; i++) {
            int len = current.length();
            StringBuilder next = new StringBuilder(len * 2 + 1);
            next.append(current).append('1');
            for (int j = len - 1; j >= 0; j--) {
                next.append(current.charAt(j) == '0' ? '1' : '0');
            }
            current = next;
        }

        return current.charAt(k - 1);
    }

    @Test
    public void test1() {
        assertEquals('0', findKthBit(3, 1));
    }

    @Test
    public void test2() {
        assertEquals('1', findKthBit(4, 11));
    }

}
