package incomplete;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class NumbersWithSameConsecutiveDifferences {

    public void depthFirstSearch(List<Integer> result, int currentDigit, int currentLength, int n, int k) {
        if (currentLength == n) {
            result.add(currentDigit);
            return;
        }
        // 0 -> 9
        for (int i = 0; i <= 9; i++) {
            int unit_digit = currentDigit % 10;
            int diff = Math.abs(unit_digit - i);
            if (diff == k) {
                currentDigit = currentDigit * 10 + i;
                depthFirstSearch(result, currentDigit, currentLength + 1, n, k);
                currentDigit /= 10;
            }
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        // 1 -> 9
        for (int i = 1; i <= 9; i++) {
            depthFirstSearch(result, i, 1, n, k);
        }
        return result.stream().mapToInt(t -> t).toArray();
    }


    @Test
    public void test() {
        // sortAndTest(new int[]{181, 292, 707, 818, 929}, numsSameConsecDiff(3, 7));
        sortAndTest(new int[]{10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98},
                numsSameConsecDiff(2, 1));
    }

    public void sortAndTest(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

}
