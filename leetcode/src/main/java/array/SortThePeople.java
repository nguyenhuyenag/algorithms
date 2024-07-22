package array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
    https://leetcode.com/problems/sort-the-people/

    Sắp xếp tên theo chiều cao

    Example 1:
        Input: names = ["Mary","John","Emma"], heights = [180,165,170]
        Output: ["Mary","Emma","John"]

    Example 2:
        Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
        Output: ["Bob","Alice","Bob"]
 */
public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        int size = names.length;
        List<AbstractMap.SimpleEntry<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new AbstractMap.SimpleEntry<>(names[i], heights[i]));
        }
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        for (int i = 0; i < size; i++) {
            names[i] = list.get(i).getKey();
        }
        return names;
    }

    @Disabled
    @Test
    public void test1() {
        assertArrayEquals(new String[]{"Mary", "Emma", "John"},
                sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new String[]{"Bob", "Alice", "Bob"},
                sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}));
    }

}
