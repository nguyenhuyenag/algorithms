package number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/add-digits/
 *
 * Cộng các chữ chữ chữ số cho đến khi chỉ còn 1 chữ số
 *
 * Xem them: codewars > SumOfDigits
 */
public class AddDigits {

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    /*-
     * ABCD = 1000A + 100B + 10*C + D = (A + B + C + D) + 9 * (111 * A + 11 * B + C)
     *                                => (mod 9) to A + B + C + D
     */
    public int addDigits2(int n) {
        if (n == 0) return 0;
        if (n % 9 == 0) {
            return 9;
        }
        return n % 9;
    }

    @Test
    public void test() {
        int n = 125564;
        assertEquals((sumOfDigits(n)), addDigits2(38));
    }

    //	public int addDigits1(int n) {
//		while (true) {
//			n = sumOfDigits(n);
//			if (n < 10) {
//				break;
//			}
//		}
//		return n;
//	}

//	public int addDigits2(int n) {
//		while (n >= 10) {
//			int sum = 0;
//			while (n > 0) {
//				sum += n % 10;
//				n /= 10;
//			}
//			n = sum;
//		}
//		return n;
//	}

//	public int addDigits3(int n) {
//		while (n >= 10) {
//			n = n / 10 + n % 10;
//		}
//		return n;
//	}

}
