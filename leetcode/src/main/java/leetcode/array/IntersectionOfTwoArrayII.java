package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Tìm phần tử chung của 2 mảng
 */
public class IntersectionOfTwoArrayII {

    public int[] intersect(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                result.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        // int[] arr = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] arr = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println("arr = " + Arrays.toString(arr));
    }

}
