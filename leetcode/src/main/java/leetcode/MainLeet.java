package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class MainLeet {

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        // System.out.println(String.format("m = %s, n = %s", m, n));
//        for (int i = 0; i < m; i++) {
//            int l = 0, r = n - 1;
//            // System.out.println(Arrays.toString(matrix[i]));
//            while (l <= r) {
//                int mid = l + (r - l) / 2;
//                if (matrix[i][mid] == target) {
//                    return true;
//                } else if (matrix[i][mid] < target) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Test
//    public void test() {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        // assertEquals(true, searchMatrix(matrix, 3));
//        // assertEquals(false, searchMatrix(matrix, 61));
//        // assertEquals(true, searchMatrix(new int[][]{{1}}, 1));
//        assertEquals(true, searchMatrix(new int[][]{{1, 3}}, 3));
//    }

}
