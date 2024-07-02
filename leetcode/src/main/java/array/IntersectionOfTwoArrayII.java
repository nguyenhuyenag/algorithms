package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Tìm phần tử chung của 2 mảng
 */
public class IntersectionOfTwoArrayII {

    public int[] intersect_1(int[] nums1, int[] nums2) {
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

    // Sử dụng map counter
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums1) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            int v = counter.getOrDefault(num, 0);
            if (v > 0) {
                result.add(num);
                counter.put(num, v - 1);
            }
        }

        return result.stream()
                .sorted() // sort để test, thực tế không cần sort
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Disabled
    @Test
    public void test1() {
        assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{4, 9}, intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

}
