package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://www.codewars.com/kata/538948d4daea7dc4d200023f/

    Đếm số bước cần thực hiện để chuyển số a thành b ở dạng binary
 */
public class DeltaBits {

    public static int convertBits_OK(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    public static int convertBits(int a, int b) {
        String aBits = Integer.toBinaryString(a);
        String bBits = Integer.toBinaryString(b);

        int maxLength = Math.max(aBits.length(), bBits.length());

        aBits = String.format("%" + maxLength + "s", aBits).replace(' ', '0');
        bBits = String.format("%" + maxLength + "s", bBits).replace(' ', '0');

        int count = 0;
        for (int i = 0; i < maxLength; i++) {
            if (aBits.charAt(i) != bBits.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, convertBits(31, 14));
    }

}
