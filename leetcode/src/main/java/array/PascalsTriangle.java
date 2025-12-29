package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*-
    https://leetcode.com/problems/pascals-triangle/

    Cho số nguyên n, trả về n dòng của tam giác Pascal.

    Trong tam giác Pascal, mỗi số bằng tổng của hai số nằm trực tiếp phía trên nó,
    như hình minh họa:
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate_ok(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // Phần tử đầu tiên luôn là 1
            row.add(1);
            // Các phần tử ở giữa
            for (int j = 1; j < i; j++) {
                List<Integer> integers = result.get(i - 1);
                int value = integers.get(j - 1) + integers.get(j);
                row.add(value);
            }
            // Phần tử cuối cùng (nếu không phải hàng đầu)
            if (i > 0) {
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        // Tam giác Pascal có n hàng
        for (int i = 0; i < n; i++) {
            // Khởi tạo tất cả phần tử là 1
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            Collections.fill(row, 1);
            // Cập nhật các phần tử ở giữa
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = triangle.get(i - 1);
                row.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    @Test
    public void test1() {
        // @formatter:off
        List<List<Integer>> result = List.of(
            List.of(1)
        );
        assertIterableEquals(result, generate(1));
        // @formatter:on
    }

    @Test
    public void test2() {
        // @formatter:off
        List<List<Integer>> result = List.of(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1)
        );
        assertIterableEquals(result, generate(5));
        // @formatter:on
    }

}
