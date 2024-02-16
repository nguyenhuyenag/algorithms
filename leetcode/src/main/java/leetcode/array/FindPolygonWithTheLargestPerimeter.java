package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 *
 * Các số a1, a2,... tạo thành 1 đa giác lồi nếu một số nhỏ hơn tổng của các số còn lại.
 * Cho mảng số nguyên dương, trả về chu vi lớn nhất có thể tạo được các số trong mảng
 *
 * Ý tưởng: Duyệt mảng, nếu có phần tử không thỏa thì xóa nó ra khỏi mảng
 */
public class FindPolygonWithTheLargestPerimeter {

    public long largestPerimeter(int[] nums) {
        // Chuyển thành List và đảo ngược
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Tỉnh tổng các phần từ
        long p = list.stream().mapToLong(Integer::longValue).sum();
        while (list.size() > 2) {
            boolean flag = true;
            // Duyệt list, nếu có phần từ nào mà > tất cả các số còn lại thì xóa nó ra khỏi list
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                if (p - x <= x) {
                    p -= x;
                    list.remove(i);
                    flag = false;
                    break;
                }
            }
            if (flag) return p;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(15, largestPerimeter(new int[]{5, 5, 5}));
        assertEquals(-1, largestPerimeter(new int[]{5, 5, 50}));
        assertEquals(12, largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
    }

    //    public long largestPerimeter_OK(int[] nums) {
//        // Chuyển thành List và đảo ngược
//        List<Integer> list = Arrays.stream(nums)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//        // Tỉnh tổng các phần từ
//        long p = list.stream().mapToLong(Integer::longValue).sum();
//        while (list.size() > 2) {
//            int i;
//            // Duyệt list, nếu có phần từ nào mà > tất cả các số còn lại thì xóa nó ra khỏi list
//            for (i = 0; i < list.size(); i++) {
//                int x = list.get(i);
//                if (p - x <= x) {
//                    p -= x;
//                    list.remove(i);
//                    break;
//                }
//            }
//            if (i == list.size()) return p;
//        }
//        return -1;
//    }

}
