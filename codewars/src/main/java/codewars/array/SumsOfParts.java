package codewars.array;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*-
 * https://www.codewars.com/kata/5ce399e0047a45001c853c2b/
 *
 * Tỉnh tổng các phần tử của mãng khi loại bỏ lần lượt các phần tử
 *
 * 		ls = [0, 1, 3, 6, 10]
 * Thao tác
 * 		ls = [0, 1, 3, 6, 10]
 * 		ls = [1, 3, 6, 10]
 * 		ls = [3, 6, 10]
 * 		ls = [6, 10]
 * 		ls = [10]
 * 		ls = []
 *
 * Kết quả: [20, 20, 19, 16, 10, 0]
 */
public class SumsOfParts {

    public static int[] sumParts(int[] ls) {
        int[] ans = new int[ls.length + 1];
        // Tổng tất cả phần tử trong mảng
        int total = Arrays.stream(ls).sum();
        for (int i = 0; i < ls.length; i++) {
            // Mỗi bước lặp, gán tổng vào mảng kết quả (phần tử đầu tiên total  - 0)
            ans[i] = total;
            //
            total -= ls[i];
        }
        ans[ls.length] = 0; // Gán giá trị cuối cùng của mảng ans
        return ans;
    }

    public static int[] sumParts0(int[] ls) {
        int[] ans = new int[ls.length + 1];
        for (int i = ls.length - 1; i >= 0; --i) {
            ans[i] = ans[i + 1] + ls[i];
        }
        return ans;
    }

    private static void dotest(int[] ls, int[] expect) {
        int[] actual = sumParts(ls);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test() {
        // dotest(new int[]{}, new int[]{0});
        dotest(new int[]{0, 1, 3, 6, 10}, new int[]{20, 20, 19, 16, 10, 0});
        // dotest(new int[]{1, 2, 3, 4, 5, 6}, new int[]{21, 20, 18, 15, 11, 6, 0});
        // dotest(new int[]{744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358}, new int[]{10037855,
        //        9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0});

    }

}
