package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 *
 * Cho mảng n (chẵn) phần tử và số k. Kiểm tra xem mảng có thể chia thành n/2
 * cặp (x,y) sao cho x+y chia hết cho k không?
 */
public class ArrayPairDivisible {

    public boolean canArrange(int[] arr, int k) {
        int count = 0;
        Arrays.sort(arr);  // Sắp xếp mảng để sử dụng two-pointer
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum % k == 0) {
                count++;
                System.out.print("(" + arr[left] + ", " + arr[right] + ") ");
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
            // if (k == 0) return true;
        }
        System.out.println();
        System.out.println("count = " + count);
        return count == arr.length / 2;  // Nếu left vượt qua right, có nghĩa là đã kiểm tra hết tất cả các cặp và thỏa mãn điều kiện
    }

    @Test
    public void test() {
        // assertEquals(true, canArrange(new int[]{-10, 10}, 2));
        // assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));

        assertEquals(true, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 3));

        // assertEquals(false, canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        // assertEquals(true, canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
    }

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
