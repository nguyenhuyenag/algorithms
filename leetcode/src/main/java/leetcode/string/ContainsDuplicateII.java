package leetcode.string;

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

//	public static boolean containsNearbyDuplicate(int[] nums, int k) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (map.containsKey(nums[i])) {
//				if (i - map.get(nums[i]) <= k) {
//					return true;
//				}
//			}
//			map.put(nums[i], i);
//		}
//		return false;
//	}

//    public boolean containsNearbyDuplicate(int[] arr, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            int ai = arr[i];
//            if (map.containsKey(ai)) {
//                int j = map.get(ai);
//                if (Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//            map.put(ai, i);
//        }
//        return false;
//    }

    public boolean containsNearbyDuplicate(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int ai = arr[i];
            int j = map.getOrDefault(ai, -1); // Default to -1 if key not present
            if (j != -1 && Math.abs(i - j) <= k) {
                return true;
            }
            map.put(ai, i);
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
