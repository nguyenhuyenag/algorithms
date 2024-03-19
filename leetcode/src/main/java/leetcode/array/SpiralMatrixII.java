package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Cho ma trận kích thước m x n. Điển các số từ 1 -> n^2 vào ma trận theo hình xoắn ốc
 *
 * Xem thêm codewars > Snail.java
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0, right = n - 1; // Cột hiện tại
        int top = 0, bottom = n - 1; // Dòng hiện tại

        int p = 1;
        while (left <= right && top <= bottom) {
            // Từ trái qua phải
            for (int i = left; i <= right; i++) {
                matrix[top][i] = p++; // Cố định dòng, tăng cột
            }
            top++; // Dòng tiếp theo (di chuyển xuống dưới)

            // Từ trên xuống dưới
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = p++; // Cố định cột, tăng dòng
            }
            right--; // Cột tiếp theo (di chuyển qua trái)

            // Từ phải qua trái
            if (top <= bottom) { // Nếu vẫn còn dòng (để thực hiện bottom++)
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = p++; // Cố định dòng, giảm cột
                }
                bottom--; // Dòng tiếp theo (di chuyển lên trên)
            }

            // Từ dưới lên trên
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = p++; // Cố định cột, giảm dòng
                }
                left++; // Cột tiếp theo (di chuyển qua phải)
            }
        }
        // System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        assertArrayEquals(matrix, generateMatrix(3));
    }
}
