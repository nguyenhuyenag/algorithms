package leetcode.incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*-
 * https://leetcode.com/problems/sum-of-distances/
 *
 * Cho mảng số nguyên A. Với mỗi A[i] nếu có A[j] (i != j) mà A[i] = A[j] ta tính tổng của
 * |i - j|, nếu không có thì gán là 0. Trả về mảng mới sau khi thực hiện thao tác trên
 *
 * Ví dụ: Input: A = [1,3,1,1,2], Output: [5,0,3,4,0]
 *
 * Với i = 0, A[0] = 1 và có A[2] = 1, A[3] = 0. Nên ta có tổng |0 - 2| + |0 - 3| = 5
 * Với i = 1, A[1] = 3, không có giá trị j nào để A[j] = 3 nên kết quả là 0
 */
public class SumOfDistances {

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Create the map
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
        }

        // Step 2: Calculate distances
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            List<Integer> integerList = map.get(num);
            long sum = 0;
            for (int j : integerList) {
                sum += Math.abs(i - j);
            }
            result[i] = sum;
        }

        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new long[]{5, 0, 3, 4, 0}, distance(new int[]{1, 3, 1, 1, 2}));
    }

    // O(n^2) solution
//    public long[] distance_(int[] nums) {
//        int n = nums.length;
//        long[] result = new long[n];
//        int p = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = 0; j < n; j++) {
//                if (i != j && nums[i] == nums[j]) {
//                    sum += Math.abs(i - j);
//                }
//            }
//            result[p++] = sum;
//        }
//        return result;
//    }

}
