package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 *
 * Tìm các phần tử khác nhau của 2 mảng
 *
 * [1,2,3], [2,4,6] -> [[1,3],[4,6]]
 */
public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference_OK(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));

        // Tìm hiệu nums1 - nums2
        Set<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);
        result.add(new ArrayList<>(diff1));

        // Tìm hiệu nums2 - nums1
        Set<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);
        result.add(new ArrayList<>(diff2));

        return result;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> diff1 = set1.stream().filter(t -> !set2.contains(t)).collect(Collectors.toList());
        List<Integer> diff2 = set2.stream().filter(t -> !set1.contains(t)).collect(Collectors.toList());

        return List.of(diff1, diff2);
    }

    @Test
    public void test() {
        // assertIterableEquals(List.of(List.of(1, 3), List.of(4, 6)), findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        assertIterableEquals(List.of(List.of(3), Collections.emptyList()),
                findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

}
