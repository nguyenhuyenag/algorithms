package array.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/special-positions-in-a-binary-matrix/

    Cho một ma trận nhị phân kích thước m x n là mat, hãy trả về số lượng
    các vị trí đặc biệt trong mat.

    Một vị trí (i, j) được gọi là đặc biệt nếu:
        - mat[i][j] == 1
        - Tất cả các phần tử khác trong hàng i và cột j đều bằng 0

    (Lưu ý: Chỉ số hàng và cột được đánh số từ 0.)
 */
public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        // Tính tổng hàng và cột
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        int count = 0;

        // Kiểm tra special position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(1, numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    @Test
    public void test2() {
        assertEquals(3, numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

}
