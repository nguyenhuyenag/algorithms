package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 *
 * Kiểm tra bit xen kẻ
 *
 *      5 = 101 -> true
 */
public class BinaryAlternatingBit {

//	public static boolean hasAlternatingBits(int n) {
//		char[] A = Integer.toBinaryString(n).toCharArray();
//		if (A[0] == '0') { // a0 = 0
//			// a_chẵn = 0, a_lẻ = 1
//			for (int i = 1; i < A.length; i++) {
//				if (i % 2 == 0 && A[i] != '0') {
//					return false;
//				}
//				if (i % 2 != 0 && A[i] != '1') {
//					return false;
//				}
//			}
//		} else { // a0 = 1
//			// a_chẵn = 1, a_lẻ = 0
//			for (int i = 1; i < A.length; i++) {
//				if (i % 2 == 0 && A[i] != '1') {
//					return false;
//				}
//				if (i % 2 != 0 && A[i] != '0') {
//					return false;
//				}
//			}
//		}
//		return true;
//	}

    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length() - 1; i++) {
            int x = binary.charAt(i);
            int y = binary.charAt(i + 1);
            if (Math.abs(x - y) != 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, hasAlternatingBits(5));
        assertEquals(false, hasAlternatingBits(7));
        assertEquals(false, hasAlternatingBits(11));
        assertEquals(true, hasAlternatingBits(10));
        assertEquals(false, hasAlternatingBits(3));
    }

}
