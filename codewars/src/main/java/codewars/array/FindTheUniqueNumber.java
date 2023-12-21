package codewars.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/585d7d5adb20cf33cb000235/
 *
 * Tìm số duy nhất trong mảng
 */
public class FindTheUniqueNumber {

    public static double findUniq1(double[] arr) {
        int index = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            double x = arr[i];
            for (int j = 0; j < n; j++) {
                if (x == arr[j]) {
                    count++;
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                index = i;
            }
        }
        return arr[index];
    }

    public static double findUniq(double[] arr) {
        Map<Double, Integer> countNums = new HashMap<>();
        for (double d : arr) {
            countNums.put(d, countNums.getOrDefault(d, 0) + 1);
        }
        for (Map.Entry<Double, Integer> e : countNums.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey().doubleValue();
            }
        }
        return -1;
    }

    @Test
    public void sampleTestCases() {
        assertEquals(2, findUniq(new double[]{1, 1, 1, 2, 1, 1}));
        // assertEquals(0.55, findUniq(new double[]{0, 0, 0.55, 0, 0}));
    }

}
