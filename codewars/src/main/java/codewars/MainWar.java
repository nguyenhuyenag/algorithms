package codewars;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainWar {

    public static int minSum(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            sum += (arr[l] * arr[r]);
            // System.out.println(arr[l] + " , " + arr[r]);
            l++;
            r--;
        }
        return sum;
    }

    @Test
    public void checkLargerValues() {
        assertEquals(22, minSum(new int[]{5, 4, 2, 3}));
        assertEquals(342, minSum(new int[]{12, 6, 10, 26, 3, 24}));
        assertEquals(74, minSum(new int[]{9, 2, 8, 7, 5, 4, 0, 6}));
    }

}
