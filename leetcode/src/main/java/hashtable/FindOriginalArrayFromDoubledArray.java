package hashtable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/find-original-array-from-doubled-array/

    Cho mảng số nguyên chứa cả mảng gốc và các giá trị nhân đôi. Tìm mảng gốc.
 */
public class FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);

        int i = 0;
        int[] result = new int[n / 2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : changed) {
            if (x % 2 == 0 && map.getOrDefault(x / 2, 0) > 0) {
                result[i++] = x / 2;
                map.put(x / 2, map.get(x / 2) - 1);
            } else {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        return (i == n / 2) ? result : new int[0];
    }

    @Test
    public void test() {
        sortAndTest(new int[]{1, 3, 4}, findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}));
        sortAndTest(new int[]{}, findOriginalArray(new int[]{6, 3, 0, 1}));
        sortAndTest(new int[]{}, findOriginalArray(new int[]{0}));
    }

    public void sortAndTest(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

}
