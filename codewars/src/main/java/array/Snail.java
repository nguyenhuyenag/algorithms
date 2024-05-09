package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/
 *
 * Cho ma trận vuông n x n. In ra ma trận theo hình xoắn ốc
 *
 * Xem thêm leetcode > SpiralMatrix.java
 */
public class Snail {

    public static int[] snail(int[][] matrix) {
        int rows = matrix.length; // Số dòng
        int cols = matrix[0].length; // Số cột

        int top = 0, bottom = rows - 1; // Dòng hiện tại
        int left = 0, right = cols - 1; // Cột hiện tại

        int p = 0;
        int[] result = new int[rows * cols];

        while (left <= right && top <= bottom) {
            // In từ trái qua phải
            for (int i = left; i <= right; i++) {
                result[p++] = matrix[top][i];
            }
            top++; // Dòng tiếp theo

            // In từ trên xuống duới
            for (int i = top; i <= bottom; i++) {
                result[p++] = matrix[i][right];
            }
            right--; // Cột tiếp theo (bên trái)

            // In phần dưới cùng, từ phải qua trái
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[p++] = matrix[bottom][i];
                }
                bottom--; // Dòng tiếp theo (trên nó)
            }

            // In từ dưới lên trên
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[p++] = matrix[i][left];
                }
                left++;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, snail(matrix1));
    }

}
