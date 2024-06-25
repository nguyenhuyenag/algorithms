package array;

import org.junit.jupiter.api.Test;

public class FillArray {

//    public void fill2D(int[][] matrix, int value) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for (int i = 0; i < m * n; i++) {
//            int row = i / n;
//            int col = i % n;
//            matrix[row][col] = value;
//        }
//    }
//
//    @Test
//    public void test() {
//        int[][] matrix = new int[5][6];
//        fill2D(matrix, -1);
//        for (int[] row : matrix) {
//            System.out.println(Arrays.toString(row));
//        }
//    }

    @Test
    public void test() {
        // Khởi tạo ma trận 2D
        int m = 10_000; // số hàng
        int n = 10_000; // số cột
        int[][] matrix = new int[m][n];
        int value = 5; // giá trị cần gán

        // Đo thời gian cho phương thức fill2D
        long startTime1 = System.currentTimeMillis();
        fill2D(matrix, value);
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println("Thời gian thực thi của fill2D: " + duration1 + " milliseconds");

        // Đo thời gian cho phương thức fill2DWithNestedLoops
        long startTime2 = System.currentTimeMillis();
        fill2DWithNestedLoops(matrix, value);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Thời gian thực thi của fill2DWithNestedLoops: " + duration2 + " milliseconds");
    }

    public void fill2D(int[][] matrix, int value) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            int row = i / n;
            int col = i % n;
            matrix[row][col] = value;
        }
    }

    public void fill2DWithNestedLoops(int[][] matrix, int value) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value;
            }
        }
    }

}
