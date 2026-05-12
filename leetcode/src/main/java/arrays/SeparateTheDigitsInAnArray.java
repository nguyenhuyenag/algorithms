package arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    2573. Separate the Digits in an Array
    https://leetcode.com/problems/separate-the-digits-in-an-array/
 */
public class SeparateTheDigitsInAnArray {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            String str = String.valueOf(num);
            for (char c : str.toCharArray()) {
                list.add(Character.getNumericValue(c));
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 3, 2, 5, 8, 3, 7, 7}, separateDigits(new int[]{13, 25, 83, 77}));
    }

}
