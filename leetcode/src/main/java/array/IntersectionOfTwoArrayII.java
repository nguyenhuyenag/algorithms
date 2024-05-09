package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Tìm phần tử chung của 2 mảng
 */
public class IntersectionOfTwoArrayII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        // int[] arr = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] arr = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        // System.out.println("arr = " + Arrays.toString(arr));
        assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

}
