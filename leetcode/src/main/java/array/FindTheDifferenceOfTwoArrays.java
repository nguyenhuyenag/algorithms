package array;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/*-
    https://leetcode.com/problems/find-the-difference-of-two-arrays/

    Tìm các phần tử khác nhau của 2 mảng:

        [1,2,3], [2,4,6] -> [[1,3],[4,6]]
*/
public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int x : nums1) set1.add(x);
        for (int x : nums2) set2.add(x);

        // Sao chép cho đúng hiệu
        Set<Integer> diff1 = new HashSet<>(set1);
        Set<Integer> diff2 = new HashSet<>(set2);

        diff1.removeAll(set2); // Hiệu nums1 - nums2
        diff2.removeAll(set1); // Hiệu nums2 - nums1

        return List.of(new ArrayList<>(diff1), new ArrayList<>(diff2));
    }

    public List<List<Integer>> findDifference_OK1(int[] nums1, int[] nums2) {
        List<Integer> set1 = Arrays.stream(nums1).boxed().toList();
        List<Integer> set2 = Arrays.stream(nums2).boxed().toList();

        // Tìm hiệu nums1 - nums2
        Set<Integer> diff1 = new HashSet<>(set1);
        // diff1.removeAll(set2); // Call to 'set.removeAll(list)' may work slowly
        set2.forEach(diff1::remove);

        // Tìm hiệu nums2 - nums1
        Set<Integer> diff2 = new HashSet<>(set2);
        set1.forEach(diff2::remove);

        return List.of(new ArrayList<>(diff1), new ArrayList<>(diff2));
    }

    public List<List<Integer>> findDifference_OK(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> diff1 = set1.stream().filter(t -> !set2.contains(t)).toList();
        List<Integer> diff2 = set2.stream().filter(t -> !set1.contains(t)).toList();

        return List.of(diff1, diff2);
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(List.of(1, 3), List.of(4, 6)), findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        assertIterableEquals(List.of(List.of(3), Collections.emptyList()), findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

}
