package array;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/relative-sort-array/

    Cho mảng arr1 và arr2 (các phần tử là duy nhất). Sắp xếp lại arr1 theo thứ tự các
    phần tử trong arr2.

    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    Output: [2,2,2,1,4,3,3,9,6,7,19]

    Giải thích: 2 là số đứng đầu trong arr2 nên ta có   [2,2,2,...]
                1 là số kế tiếp nên ta được             [2,2,2,1,...]

    Xem thêm: leetcode > CustomSortString.java
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] nums, int[] order) {
        // Lưu giá trị và vị trí của giá trị đó trong order
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            iMap.put(order[i], i);
        }
        List<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Sắp xếp theo tiêu chí trong iMap, nếu có 2 giá trị giống nhau MAX_VALUE
        // (tức nó không có trong order) thì sắp xếp theo tứ tự natural cua nó
        result.sort((v1, v2) -> {
            int i1 = iMap.getOrDefault(v1, Integer.MAX_VALUE);
            int i2 = iMap.getOrDefault(v2, Integer.MAX_VALUE);
            return i1 == i2 ? v1 - v2 : i1 - i2;
        });
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] order = {2, 1, 4, 3, 9, 6};
        assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, relativeSortArray(nums, order));
    }

    @Test
    public void test2() {
        int[] nums = {28, 6, 22, 8, 44, 17};
        int[] order = {22, 28, 8, 6};
        assertArrayEquals(new int[]{22, 28, 8, 6, 17, 44}, relativeSortArray(nums, order));
    }

}
