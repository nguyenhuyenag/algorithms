package codewars.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/58afce23b0e8046a960000eb/
 */
public class WithDraw {

    private static int[] bills = new int[]{100, 50, 20};

    public static int[] withdraw(int n) {
        int[] result = new int[bills.length];
        for (int i = 0; i < bills.length; i++) {
            result[i] = n / bills[i];
            n = n % bills[i];
        }
        return finalizeResult(result, n);
    }

    private static int[] finalizeResult(int[] result, int remainder) {
        if (remainder == 0) return result;
        if (result[1] > 0) {
            return new int[]{result[0], result[1] - 1, result[2] + 3};
        }
        return new int[]{result[0] - 1, result[1] + 1, result[2] + 3};
    }

    @Test
    public void BasicTests() {
        // assertArrayEquals(new int[]{0, 0, 2}, withdraw(40));
        assertArrayEquals(new int[]{2, 1, 0}, withdraw(250));
        // assertArrayEquals(new int[]{2, 0, 3}, withdraw(260));
        // assertArrayEquals(new int[]{1, 1, 4}, withdraw(230, moneys));
        // assertArrayEquals(new int[]{0, 0, 3}, withdraw(60, moneys));
    }

}
