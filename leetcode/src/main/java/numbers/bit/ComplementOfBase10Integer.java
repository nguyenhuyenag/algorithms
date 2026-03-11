package numbers.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/complement-of-base-10-integer/

    Cho số nguyên n -> Chuyển nó sang nhị phân
                    -> Đảo ngược các bit: '0' -> '1', '1' -> '0'
                    -> Trả về gía trị thập phân.
    Ví dụ:

        10110 = 1×2⁴ + 0×2³ + 1×2² + 1×2¹ + 0×2⁰
 */
public class ComplementOfBase10Integer {

    public int bitwiseComplement_OK1(int n) {
        StringBuilder result = new StringBuilder();
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length(); i++) {
            result.append(binaryString.charAt(i) == '0' ? '1' : '0');
        }
        return Integer.parseInt(result.toString(), 2);
    }

    public int bitwiseComplement_OK2(int n) {
        if (n == 0) return 1;

        int result = 0;
        int base = 1;   // Giá trị bit hiện tại: 2^0, sau mỗi vòng lặp sẽ thành 2^1, 2^2, ...

        while (n > 0) {
            // Chia nhị phân đồng thời đổi bit
            int b = n % 2 == 0 ? 1 : 0;
            result += b * base;
            base *= 2;
            n /= 2;
        }

        return result;
    }

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int result = 0;
        int base = 1;   // Giá trị bit hiện tại: 2^0, sau mỗi vòng lặp sẽ thành 2^1, 2^2, ...

        while (n > 0) {
            // Chia nhị phân đồng thời đổi bit
            int b = n % 2;
            // Flip bit có thể viết gọn: 1 - b
            result += (1 - b) * base;
            base *= 2;
            n /= 2;
        }

        return result;
    }

    @Test
    public void test() {
        assertEquals(2, bitwiseComplement(5));
        assertEquals(0, bitwiseComplement(7));
        assertEquals(5, bitwiseComplement(10));
    }

}
