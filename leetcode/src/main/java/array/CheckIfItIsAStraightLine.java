package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/check-if-it-is-a-straight-line/

    Cho mảng chứa các điểm tọa độ, kiểm tra xem chúng có thẳng hàng không.

    Xét 3 điểm A(x₁,y₁), B(x₂,y₂), C(x₃,y₃). Nếu diện tích S(ABC) = 0 thì 3 điểm thẳng hàng.

    Công thức: 2 * S(ABC) = |(x2 - x1)(y3 - y1) - (x3 - x1)(y2 - y1)| = 0
 */
public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] arr) {
        int n = arr.length - 1;
        int x1 = arr[0][0], y1 = arr[0][1];
        int x3 = arr[n][0], y3 = arr[n][1];
        for (int i = 1; i < n; i++) {
            int x2 = arr[i][0], y2 = arr[i][1];
            if ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        assertEquals(false, checkStraightLine(new int[][]{{1, 2}, {2, 5}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

}
