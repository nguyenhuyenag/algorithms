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
        int[] div = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            div[i] = nums[i] % k; //  (nums[i] % k + k) % k;
            map.computeIfAbsent(nums[i] % k, x -> new ArrayList<>()).add(i);
            // map.computeIfAbsent(-nums[i] % k, x -> new ArrayList<>()).add(i);
        }

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("div = " + Arrays.toString(div));
        System.out.println("group = " + map);
        List<Integer> div0 = map.get(0);
        if (div0 != null) {
            System.out.println("(" + nums[div0.get(0)] + "," + nums[div0.get(1)] + ")");
            map.remove(0);
        }
        for (int i = 1; i <= k / 2; i++) {
            // System.out.println(i);
            List<Integer> divi = map.get(i);
            List<Integer> divi1 = map.get(k - i);
            if (divi != null && divi1 != null) {
                if (divi.size() <= 1 && divi1.size() <= 1)
                    System.out.println("(" + nums[divi.get(0)] + "," + nums[divi1.get(0)] + ")");
                if (divi.size() <= 2 && divi1.size() <= 2)
                    System.out.println("(" + nums[divi.get(1)] + "," + nums[divi1.get(1)] + ")");
                map.remove(i);
                map.remove(k - i);
            }
        }
        System.out.println("group = " + map);
        return true;
    }

    @Test
    public void test() {
        // assertEquals(true, canArrange(new int[]{-10, 10}, 2));
        // assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        // assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 3));
        // assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));

        // assertEquals(false, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        assertEquals(true, canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
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
