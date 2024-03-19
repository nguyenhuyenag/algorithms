package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Cho ma trận kích thước m x n. In ra ma trận theo hình xoắn ốc
 *
 * Xem thêm codewars > Snail.java
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length; // Dòng
        int n = matrix[0].length; // Cột

        int top = 0, bottom = m - 1; // Dòng hiện tại
        int left = 0, right = n - 1; // Cột hiện tại

        while (left <= right && top <= bottom) {
            // Từ trái qua phải
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]); // Cố định dòng, tăng cột
            }
            top++; // Dòng tiếp theo (di chuyển xuống dưới)

            // Từ trên xuống dưới
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]); // Cố định cột, tăng dòng
            }
            right--; // Cột tiếp theo (di chuyển qua trái)

            // Từ phải qua trái
            if (top <= bottom) { // Nếu vẫn còn dòng (để thực hiện bottom++)
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]); // Cố định dòng, giảm cột
                }
                bottom--; // Dòng tiếp theo (di chuyển lên trên)
            }

            // Từ dưới lên trên
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]); // Cố định cột, giảm dòng
                }
                left++; // Cột tiếp theo (di chuyển qua phải)
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
        assertIterableEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralOrder(matrix1));
    }
}
