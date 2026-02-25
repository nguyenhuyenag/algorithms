package number.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

    Cho 2 số nguyên dạng nhị phân,
 */
public class MinimumBitFlipsToConvertNumber {

    public int minBitFlips_OK(int start, int goal) {
        int count = 0;
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);

        int diff = s1.length() - s2.length();
        if (diff < 0) {
            s1 = "0".repeat(Math.abs(diff)) + s1;  // Pad s1 with leading zeros
        } else {
            s2 = "0".repeat(Math.abs(diff)) + s2;  // Pad s2 with leading zeros
        }

        // Compare each character to count the number of differing bits
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public int minBitFlips(int start, int goal) {
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(start));
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(goal));
        while (s1.length() < s2.length()) s1.insert(0, '0');
        while (s2.length() < s1.length()) s2.insert(0, '0');
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        // assertEquals(3, minBitFlips(10, 7));
        assertEquals(3, minBitFlips(3, 4));
    }

}
