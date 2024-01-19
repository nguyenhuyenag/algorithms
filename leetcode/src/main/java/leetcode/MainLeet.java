package leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * Cho mảng đã sắp xếp, tìm k số gần x nhất
 */
public class MainLeet {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort(Comparator.comparingInt(u -> Math.abs(u - x)));
        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }

    @Test
    public void test() {
        findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
    }

}
