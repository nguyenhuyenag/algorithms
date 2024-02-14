package leetcode.stack;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 *
 * Cho mảng số nguyên, sắp xếp lại theo thứ tự dương, âm xen kẽ
 *
 * Ví dụ: [3,1,-2,-5,2,-4] -> [3,1,2], [-2,-5,-4] -> [3,-2,1,-5,2,-4]
 */
public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> negArr = new LinkedList<>();
        LinkedList<Integer> posArr = new LinkedList<>();
        for (int v : nums) {
            if (v > 0) {
                posArr.push(v);
            } else {
                negArr.push(v);
            }
        }
        while (!posArr.isEmpty() && !negArr.isEmpty()) {
            result.add(posArr.pollLast());
            result.add(negArr.pollLast());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, -2, 1, -5, 2, -4}, rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
        assertArrayEquals(new int[]{1, -1}, rearrangeArray(new int[]{-1, 1}));
    }

}
