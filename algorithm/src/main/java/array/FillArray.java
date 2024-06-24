package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FillArray {

    public void fill2D(int[][] matrix, int value) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            int row = i / n;
            int col = i % n;
            matrix[row][col] = value;
        }
    }

    @Test
    public void test() {
        int[][] matrix = new int[5][6];
        fill2D(matrix, -1);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
