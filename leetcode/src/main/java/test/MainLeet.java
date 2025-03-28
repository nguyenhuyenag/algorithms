package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Cho một mảng số nguyên nums gồm 2 * n phần tử. Chia nums thành n cặp sao cho:

        - Mỗi phần tử thuộc chính xác một cặp.
        - Các phần tử trong một cặp phải bằng nhau.

    Trả về true nếu có thể chia nums thành n cặp thỏa mãn điều kiện trên, ngược lại trả về false.
 */
public class MainLeet {

    public boolean divideArray_OK(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int num : counter.keySet()) {
            if (counter.get(num) % 2 != 0) {
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
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if ((entry.getValue() & 1) != 0) { // Kiểm tra số lẻ bằng toán tử bitwise
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertEquals(true, divideArray(new int[]{3, 2, 3, 2, 2, 2}));
    }

    @Disabled
    @Test
    public void test2() {
        assertEquals(false, divideArray(new int[]{1, 2, 3, 4}));
    }

}
