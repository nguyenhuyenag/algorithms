package leetcode.array;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * Tìm giao của 2 mảng
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> common = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                common.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2}, intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{4, 9}, intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}
