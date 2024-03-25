package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * Tìm các phần tử xuất hiện 2 lần trong mảng
 */
public class FindAllDuptilcatesInArray {

    public List<Integer> findDuplicates_2(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        return Arrays.stream(nums)
                .filter(num -> !unique.add(num))
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(2, 3), findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
