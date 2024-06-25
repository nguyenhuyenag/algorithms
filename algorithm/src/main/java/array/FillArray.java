package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FillArray {

    private final int M = 5;
    private final int N = 5;
    private final int[][] matrix = new int[M][N];

    public void test1() {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            int row = i / n;
            int col = i % n;
            matrix[row][col] = -1;
        }
    }

    public void test2() {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public void test3() {
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
    }

    @Test
    public void test() {
        test1();
        // test2();
        // test3();
    }

}
