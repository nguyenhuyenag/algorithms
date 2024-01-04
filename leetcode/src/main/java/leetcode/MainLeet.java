package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
 *
 * Cho 1 mảng số nguyên dương, có thể chọn một trong 2 phép toán sau:
 *
 * - Tìm 2 phần tử bằng nhau và xóa chúng ra khỏi mảng
 *
 * - Tìm 3 phần tử bằng nhau và xóa chúng ra khỏi mảng
 *
 * Trả về số lần thực hiện nhỏ nhất để mảng rỗng hoặc -1 nếu không thể
 */
public class MainLeet {

    public static int[] splitNumberInto3x2y(int number) {
        int x = 0, y = 0;
        while (number > 0) {
            if (number - 3 == 0 || number - 3 >= 2) {
                number = number - 3;
                x++;
            } else {
                number = number - 2;
                y++;
            }
        }
        return new int[]{x, y, number};
    }

    public int minOperations(int[] nums) {
        int step = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        System.out.println("numCount = " + numCount);
        for (int count : numCount.values()) {
            if (count < 2) {
                return -1;
            }
            int[] split = splitNumberInto3x2y(count);
            if (split[2] > 0) {
                return -1;
            } else {
                step += (split[0] + split[1]);
            }
        }
        System.out.println("step: "+step);
        return step;
}

    @Test
    public void testSomething() {
        // assertEquals(4, minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        // assertEquals(-1, minOperations(new int[]{2,1,2,2,3,3}));
        // assertEquals(7, minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));
        assertEquals(5, minOperations(new int[]{19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19}));
    }

}
