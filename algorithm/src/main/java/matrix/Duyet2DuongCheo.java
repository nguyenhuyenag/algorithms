package matrix;

import java.util.List;

public class Duyet2DuongCheo {

    public static int diagonalDifference(List<List<Integer>> list) {
        int size = list.size();
        int dcc = 0;
        int dcp = 0;
        for (int i = 0; i < size; i++) {
            dcc += list.get(i).get(i);
            dcp += list.get(i).get(size - i - 1);
        }
        return Math.abs(dcc - dcp);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = matrix.length;
        // Duong cheo chinh
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        // Duong cheo phu
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][n - i - 1] + " ");
        }
    }

}
