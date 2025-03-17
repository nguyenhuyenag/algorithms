package hashtable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://leetcode.com/problems/divide-array-into-equal-pairs/

    Cho một mảng số nguyên nums gồm 2 * n phần tử. Chia nums thành n cặp sao cho:

        - Mỗi phần tử thuộc chính xác một cặp.
        - Các phần tử trong một cặp phải bằng nhau.

    Trả về true nếu có thể chia nums thành n cặp thỏa mãn điều kiện trên, ngược lại trả về false.
 */
public class DivideArrayIntoEqualPairs {

    public boolean divideArray_OK(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int num : counter.values()) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        for (int count : counter.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertEquals(true, divideArray(new int[]{3, 2, 3, 2, 2, 2}));
    }

    // @Disabled
    @Test
    public void test2() {
        assertEquals(false, divideArray(new int[]{1, 2, 3, 4}));
    }

}
