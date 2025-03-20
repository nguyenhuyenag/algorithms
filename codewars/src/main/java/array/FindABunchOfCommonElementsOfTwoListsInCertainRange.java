package array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    https://www.codewars.com/kata/58161c5ac7e37d17fc00002f/
 */

public class FindABunchOfCommonElementsOfTwoListsInCertainRange {

    public static List<Integer> findCommonElements(int[] arrA, int[] arrB, int[] rng, String wanted) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        Map<Integer, Integer> countB = new HashMap<>();
        // Counter
        for (int x : arrA) {
            countA.merge(x, 1, Integer::sum);
        }
        for (int x : arrB) {
            countB.merge(x, 1, Integer::sum);
        }
        // Iterate through elements in arrA
        for (int value : countA.keySet()) {
            // Check if the element is in both arrays
            if (countB.containsKey(value)) {
                // Check if the element occurs more than once in both arrays
                if (countA.get(value) > 1 && countB.get(value) > 1) {
                    // Check if the value is within the given range
                    if (value >= rng[0] && value <= rng[1]) {
                        // Check if the value matches the even/odd requirement
                        if (("even".equals(wanted) && value % 2 == 0) || ("odd".equals(wanted) && value % 2 != 0)) {
                            result.add(value);
                        }
                    }
                }
            }
        }
        result.sort(null);
        return result;
    }

    @Test
    public void testSimpleCases() {
        assertEquals(List.of(1, 3), findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 7, 1, 0, 2, 3}, new int[]{2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0}, new int[]{-4, 4}, "odd"));
        assertEquals(List.of(0, 2, 4), findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 4, 7, 1, 0, 2, 3, 0, 4}, new int[]{0, 4, 2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0, 4}, new int[]{-4, 4}, "even"));
        assertEquals(List.of(), findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 4, 7, 1, 0, 2, 3, 0, 4}, new int[]{0, 4, 2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0, 4}, new int[]{-4, -1}, "even"));
    }

}
