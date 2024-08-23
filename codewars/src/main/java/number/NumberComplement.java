package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    https://leetcode.com/problems/number-complement/

    Đảo bit: 5 = '101' -> '010' = 2
 */
public class NumberComplement {

    public int findComplement_1(int n) {
        String binary = Integer.toBinaryString(n);
        char[] arr = binary.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == '0' ? '1' : '0';
        }
        return Integer.parseInt(new String(arr), 2);
    }

    public int findComplement_2(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder reverseBit = new StringBuilder();
        for (char c : binary.toCharArray()) {
            reverseBit.append(c == '0' ? '1' : '0');
        }
        return Integer.parseInt(reverseBit.toString(), 2);
    }

    public int findComplement(int n) {
        StringBuilder complement = new StringBuilder();
        while (n > 0) {
            int lastBit = n % 2;
            complement.append(lastBit == 0 ? '1' : '0');
            n /= 2;
        }
        return Integer.parseInt(complement.reverse().toString(), 2);
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, findComplement(5));
    }

}
