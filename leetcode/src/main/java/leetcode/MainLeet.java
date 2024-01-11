package leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 */
public class MainLeet {

//    public int[] merge(int[] arrayA, int[] arrayB) {
//        int lenA = arrayA.length, lenB = arrayB.length;
//        int[] ans = new int[lenA + lenB];
//        System.arraycopy(arrayA, 0, ans, 0, lenA);
//        System.arraycopy(arrayB, 0, ans, lenA, lenB);
//        return ans;
//    }

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
        int[] arr = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println("arr = " + Arrays.toString(arr));
    }

}
