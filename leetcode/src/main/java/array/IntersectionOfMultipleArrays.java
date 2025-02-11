package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 *
 * Tìm phần tử chung của n mảng
 */
public class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {
        Set<Integer> result = Arrays.stream(nums[0]).boxed().collect(Collectors.toSet());
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> another = Arrays.stream(nums[i]).boxed().collect(Collectors.toSet());
            result.retainAll(another);
        }
        return result.stream().sorted().toList();
    }

    @Test
    public void test() {
        assertIterableEquals(List.of(3, 4), intersection(new int[][]{new int[]{3, 1, 2, 4, 5}, new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}}));
    }

}
