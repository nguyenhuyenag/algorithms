package incomplete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/valid-triangle-number/
 *
 * Đếm số lượng các số bộ 3 cạnh của tam giác trong mảng
 */
public class ValidTriangleNumber {

    public static boolean isTriangle(int side1, int side2, int side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    public int triangleNumber(int[] arr) {
        int count = 0;
        List<Integer> triangle = new ArrayList<>();
        int len = arr.length;
        int totalSubsets = 1 << len;
        for (int i = 0; i < totalSubsets; i++) {
            int bitCount = Integer.bitCount(i);
            if (bitCount == 3) {
                // int pointer = 0;
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) != 0) {
                        triangle.add(arr[j]);
                    }
                }
                if (isTriangle(triangle.get(0), triangle.get(1), triangle.get(2))) {
                    count++;
                    // System.out.println(Arrays.toString(triangle));
                }
            }
            triangle.clear();
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(3, triangleNumber(new int[]{2, 2, 3, 4}));
        assertEquals(4, triangleNumber(new int[]{4, 2, 3, 4}));
    }

}
