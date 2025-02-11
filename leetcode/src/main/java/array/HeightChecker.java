package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/height-checker/

    Một lớp học muốn chụp ảnh kỷ niệm và yêu cầu các em đứng theo thứ tự tăng dần về chiều cao.
    Mảng expected biểu diễn chiều cao mong đợi của từng học sinh trong hàng. Mảng heights là chiều
    cao hiện tại của từng học sinh trong hàng.

    => Tìm số vị trí mà chiều cao hiện tại khác với chiều cao mong đợi.

    Ví dụ: heights = [1,1,4,2,1,3], Output: 3

    Giải thích:

        heights:  [1, 1, (4), 2, (1), (3)]
        expected: [1, 1, (1), 2, (3), (4)]
        => Các vị trí 2, 4, và 5 là các vị trí không khớp.
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        // int[] expected = Arrays.copyOf(heights, heights.length);
        // Arrays.sort(expected);
        int[] expected = Arrays.stream(heights).sorted().toArray();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(3, heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

}
