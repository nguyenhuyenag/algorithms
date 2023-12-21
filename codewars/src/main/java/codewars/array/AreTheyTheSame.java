package codewars.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/550498447451fbbd7600041c
 *
 * Kiểm tra mảng b có phải là bình phương của mảng a
 */
public class AreTheyTheSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        int[] b2 = Arrays.stream(a).map(t -> t * t).toArray();
        Arrays.sort(b);
        Arrays.sort(b2);
        return Arrays.equals(b2, b);
    }

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, comp(a, b));
    }

}
