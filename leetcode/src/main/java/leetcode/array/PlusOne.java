package leetcode.array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*-
 * https://leetcode.com/problems/plus-one/submissions/1142998791/
 *
 * Cộng 1 vào mảng
 *      [1, 2, 3]   ->  [1, 2, 4]
 *      [9]         ->  [1, 0]
 */
public class PlusOne {

    public int[] plusOne(int[] arr) {
        LinkedList<Integer> result = new LinkedList<>();
        int rem = 1; // Số nhớ
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + rem;
            result.addFirst(sum % 10);
            rem = sum / 10;
        }
        if (rem > 0) {
            result.addFirst(rem);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] plusAny(int[] arr, int rem) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + rem;
            ans.addFirst(sum % 10);
            rem = sum / 10;
        }
        if (rem > 0) {
            ans.addFirst(rem);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    @Disabled
    @Test
    public void testPlusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
    }

    @Test
    public void testPlusAny() {
        assertArrayEquals(new int[]{1, 2}, plusAny(new int[]{6}, 6));
    }

}
