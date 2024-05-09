package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/5a523566b3bfa84c2e00010b/
 *
 * Cho mảng arr. Tìm giá trị của nhỏ nhất
 *
 *  S = arr[i] * arr[j] + ....
 *
 *  sao cho S nhỏ nhất
 *
 *  Giải: Sắp xếp mảng [a1, a2, ..., an]
 *
 *  -> an là số lớn nhất, nên muốn S nhỏ nhất thì phải nhân an * a1 để tích này nhỏ nhất,...
 */
public class MinimizeSumOfArray {

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
