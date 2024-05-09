package array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * Cho mảng đã sắp xếp, tìm k số gần x nhất (closer)
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 * Xem thêm: FindClosestElement.java
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements0(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort((u, v) -> Math.abs(u - x) - Math.abs(v - x));
        for (int i = 0; i < k; i++) {
            result.add(list.get(i));
        }
        Collections.sort(result);
        return result;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(t -> Math.abs(t - x)))
                .collect(Collectors.toList());
        // list.sort(Comparator.comparingInt(u -> Math.abs(u - x)));
        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }

    @Test
    public void test() {
        int[] input = {1, 2, 3, 4, 5};
        List<Integer> output = Arrays.asList(1, 2, 3, 4);
        assertIterableEquals(output, findClosestElements(input, 4, 3));
        assertIterableEquals(output, findClosestElements(input, 4, -1));
    }

}
