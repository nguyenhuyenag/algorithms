package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/maximum-size-of-a-set-after-removals/
 *
 * Cho 2 mảng số nguyên nums1, nums2 có chung kích thước n. Có thể xóa n/2
 * phần tử của num1 và n/2 phần tử của nums2. Tìm max size của set(nums1 + nums2)
 *
 * Ý tưởng: Sắp xếp theo giảm dần theo frequency -> xóa 0 -> n/2
 */
public class MaximumSizeOfSetAfterRemovals {

//    // Xóa n/2 phần tử
//    public void removeN2Map(Map<Integer, Integer> counter, int n) {
//        while (n > 0) {
//            // Hàng đợi ưu tiên theo frequency (đảo ngược)
//            Comparator<Integer> comparator = (c1, c2) -> counter.get(c2) - counter.get(c1);
//            PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
//            queue.addAll(counter.keySet());
//            int key = queue.peek();
//            int value = counter.get(key);
//            if (value > 0) {
//                counter.put(key, --value);
//                n--;
//            }
//            if (counter.get(key) == 0) {
//                counter.remove(key);
//            }
//        }
//    }
//

//    public Map<Integer, Integer> counter(int[] nums) {
//        Map<Integer, Integer> counter = new HashMap<>();
//        for (int num : nums) {
//            counter.put(num, counter.getOrDefault(num, 0) + 1);
//        }
//        return counter;
//    }

    public int maximumSetSize(int[] nums1, int[] nums2) {
        int len = nums1.length;

        Map<Integer, Integer> counter1 = new HashMap<>();
        Map<Integer, Integer> counter2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            counter1.put(nums1[i], counter1.getOrDefault(nums1[i], 0) + 1);
            counter2.put(nums2[i], counter1.getOrDefault(nums2[i], 0) + 1);
        }

        Set<Integer> result = new HashSet<>();

        int counter = 0;
        int n = len / 2;

        // Tìm phần tử có trong counter1 nhưng không có counter2
        for (int num : counter1.keySet()) {
            if (counter < n && !counter2.containsKey(num)) {
                result.add(num);
                counter++;
            }
        }

        for (int num : counter1.keySet()) {
            if (counter < n && !result.contains(num)) {
                result.add(num);
                counter++;
            }
        }

        counter = 0;
        for (int num : counter2.keySet()) {
            if (!result.contains(num) && counter < n) {
                result.add(num);
                counter++;
            }
        }

        return result.size();
    }

    @Test
    public void test() {
        assertEquals(2, maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        assertEquals(5, maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        assertEquals(6, maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
        assertEquals(4, maximumSetSize(new int[]{1, 2, 1, 1}, new int[]{1, 2, 3, 4}));
    }

}
