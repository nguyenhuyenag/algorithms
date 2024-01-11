package leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tìm i != j trong mảng sao cho nums[i] == nums[j] và abs(i - j) <= k
 */
public class MainLeet {

    public int[] plusOne(int[] arr) {
        LinkedList<Integer> ans = new LinkedList<>();
        int rem = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + rem;
            if (i == arr.length - 1) {
                sum += 1;
            }
            ans.addFirst(sum % 10);
            rem = sum / 10;
        }
        if (rem > 0) {
            ans.addFirst(rem);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
    }

}
