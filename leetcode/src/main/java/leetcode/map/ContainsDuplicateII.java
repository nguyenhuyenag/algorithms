package leetcode.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Tìm i != j trong mảng sao cho nums[i] == nums[j] và abs(i - j) <= k
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int j = map.getOrDefault(arr[i], -1); // Nếu j = -1 -> Key not present
            if (j != -1 && Math.abs(i - j) <= k) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true, containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertEquals(true, containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        assertEquals(false, containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}
