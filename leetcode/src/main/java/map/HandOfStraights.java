package map;


import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/hand-of-straights/

    Cho mảng số nguyên nums và số nguyên k. Kiểm tra xem liệu có thể chia mảng thành k mảng
    con sao cho mỗi mỗi mãng con chứ k phần tử liên tiếp.
 */
public class HandOfStraights {

    public void decrementAndRemove(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) map.remove(key);
    }

    public boolean isNStraightHand(int[] nums, int k) {
        if (nums.length % k != 0) return false;

        // Counter
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int v : nums) {
            counter.put(v, counter.getOrDefault(v, 0) + 1);
        }

        // Validate
        while (!counter.isEmpty()) {
            System.out.println(counter);
            // Lấy ra phần tử nhỏ nhất
            int min = counter.firstKey();
            for (int i = 0; i < k; i++) {
                // Tìm phần tử tiếp theo
                int current = min + i;
                // Nếu nó không có trong map tức là không thể tạo thành mảng con liên tiếp -> false
                if (!counter.containsKey(current)) {
                    return false;
                }
                System.out.print(current + " ");
                // Nếu có thì xóa nó đi và quay lại tìm phần tử kế tiếp
                decrementAndRemove(counter, current);
            }
            System.out.println();
        }
        return true;
    }

    @Test
    public void test() {
        // assertEquals(true, isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        // assertEquals(false, isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        assertEquals(true, isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }

//        public boolean isNStraightHand_Wrong(int[] nums, int k) {
//        if (nums.length % k != 0) return false;
//
//        // Counter
//        TreeMap<Integer, Integer> counter = new TreeMap<>();
//        for (int v : nums) {
//            counter.put(v, counter.getOrDefault(v, 0) + 1);
//        }
//
//        // Validate
//        int index = 0;
//        while (index < k) {
//            System.out.println(counter);
//            int key = counter.firstKey();
//            System.out.print(key + " ");
//            decrementAndRemove(counter, key);
//            for (int i = 0; i < k - 1; i++) {
//                // Tìm số liền sau
//                int nextKey = ++key;
//                if (!counter.containsKey(nextKey)) {
//                    return false;
//                }
//                System.out.print(nextKey + " ");
//                decrementAndRemove(counter, nextKey);
//            }
//            System.out.println();
//            index++;
//        }
//        return counter.size() == 0;
//    }

}
