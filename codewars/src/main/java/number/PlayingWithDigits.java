package number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://www.codewars.com/kata/5552101f47fc5178b1000050/

    Cho 2 số n, p. Kiểm tra số n có tồn tại đặc điểm

        n = 89, p = 1       89      --> 8¹ + 9² = 89 * 1
        n = 695, p = 2      695     --> 6² + 9³ + 5⁴= 1390 = 695 * 2
        n = 46288, p = 3    46288   --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 */
public class PlayingWithDigits {

    public static long digPow(int n, int p) {
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += (int) Math.pow(Character.getNumericValue(c), p++);
        }
        return sum % n == 0 ? sum / n : -1;
    }

    @Test
    public void Test1() {
        assertEquals(1, digPow(89, 1));
        assertEquals(-1, digPow(92, 1));
        assertEquals(51, digPow(46288, 3));
    }

}
