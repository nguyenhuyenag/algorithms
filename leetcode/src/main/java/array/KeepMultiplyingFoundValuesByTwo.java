package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/keep-multiplying-found-values-by-two/

    Cho số nguyên x và mảng số nguyên nums. Nếu số đó có trong mảng nums, nhân đôi nó và tiếp tục kiểm tra.
    Khi nào không còn thấy trong nums nữa thì dừng và trả về giá trị cuối cùng.
 */
public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int x) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        while (seen.contains(x)) {
            x *= 2;
        }
        return x;
    }

    public int findFinalValue_Sort(int[] nums, int x) {
        Arrays.sort(nums);
        while (Arrays.binarySearch(nums, x) >= 0) {
            x *= 2;
        }
        return x;
    }

    @Test
    public void test() {
        assertEquals(24, findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        assertEquals(4, findFinalValue(new int[]{2, 7, 9}, 4));
    }

}
