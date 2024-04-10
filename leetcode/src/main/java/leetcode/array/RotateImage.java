package leetcode.array;

import org.junit.jupiter.api.Test;


/*-
 * https://leetcode.com/problems/rotate-image/
 *
 * Cho ma trận nxn. Xoay ma trận theo chiều kim đồng hồ
 *
 *      1  2  3        7  4  1
 *      4  5  6   ->   8  5  2
 *      7  8  9        9  6  3
 */
public class RotateImage {

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public void reverseRows(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int l = 0, r = len - 1;
            while (l < r) {
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;
                l++;
                r--;
            }
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    @Test
    public void test() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("\nRotated Matrix:");
        printMatrix(matrix);
    }

}
