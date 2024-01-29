package leetcode.solved;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 *
 * Cho mảng n (chẵn) phần tử và số k. Kiểm tra xem mảng có thể chia thành n/2
 * cặp (x,y) sao cho x+y chia hết cho k không?
 */
public class ArrayPairDivisible {

    public boolean canArrange(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i] % k);
        }
        boolean[] mark = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int d1 = nums[i] % k; // Số dư của số hiện tại chia k
            // d1 + d2 = 0 or d1 + d2 % k == 0
            if (map.containsKey(k - d1)) {
                System.out.println(i + "");
            }
        }
        System.out.println("map = " + map);
        return true;
    }

    @Test
    public void test() {
        // assertEquals(true, canArrange(new int[]{-10, 10}, 2));
        // assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));

        assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 3));

        // assertEquals(false, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        // assertEquals(true, canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
    }

    //    public boolean canArrange(int[] arr, int k) {
//        int[] frequency = new int[k];
//        for (int x : arr) {
//            x %= k;
//            if (x < 0) {
//                x += k;
//            }
//            frequency[x]++;
//        }
//        if (frequency[0] % 2 != 0) {
//            return false;
//        }
//
//        System.out.println("frequency = " + Arrays.toString(frequency));
//
//        for (int i = 1; i <= k / 2; i++)
//            if (frequency[i] != frequency[k - i]) return false;
//
//        return true;
//    }

//    public int[] findPair(List<Integer> list, int k) {
//        int n = list.size();
//        int stop = n / 2;
//        for (int i = 0; i < n; i++) {
//            int a = list.get(i);
//            if (i >= stop) {
//                return new int[]{-1, -1};
//            }
//            for (int j = i + 1; j < n; j++) {
//                int b = list.get(j);
//                if ((a + b) % k == 0) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{-1, -1};
//    }
//
//    public boolean canArrange(int[] A, int k) {
//        int count = 0;
//        int stop = A.length / 2;
//        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
//        while (list.size() > 0) {
//            int[] pair = findPair(list, k);
//            if (pair[0] != -1) {
//                count++;
//                if (count == stop) {
//                    return true;
//                }
//                list.remove(pair[1]);
//                list.remove(pair[0]);
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }

}
