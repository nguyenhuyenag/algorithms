package array;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.codewars.com/kata/57b6f5aadb5b3d0ae3000611/
 */
public class LengthOfMissingArray {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) return 0;
        int[] lengths = Arrays.stream(arrayOfArrays)
                .mapToInt(arr -> arr == null ? 0 : arr.length)
                .sorted()
                .toArray();

        if (Arrays.stream(lengths).anyMatch(len -> len == 0)) {
            return 0;
        }

        for (int i = 0; i < lengths.length - 1; i++) {
            if (lengths[i] + 1 != lengths[i + 1]) {
                return lengths[i] + 1;
            }
        }

        return 0;
    }

    @Test
    public void BasicTests() {
        assertEquals(3, getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
        assertEquals(5, getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));
        assertEquals(0, getLengthOfMissingArray(new Object[][] { }));
    }

    @Disabled
    @Test
    public void test() {
        assertEquals(3, getLengthOfMissingArray(new Object[][]{new Object[]{1, 2}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{5, 2, 9}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{null}, new Object[]{null, null, null}}));
        assertEquals(5, getLengthOfMissingArray(new Object[][]{new Object[]{'a', 'a', 'a'}, new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'}, new Object[]{'a'}, new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}}));
        assertEquals(0, getLengthOfMissingArray(new Object[][]{}));
        assertEquals(5, getLengthOfMissingArray(new Object[][]{new Object[]{0, 4}, new Object[]{0}, new Object[]{1, 2, 0, 2}, new Object[]{0, 2, 3, 1, 1, 4, 3, 2, 0}, new Object[]{4, 3, 1, 3, 1, 1, 1, 3}, new Object[]{4, 2, 3, 2, 0, 4}, new Object[]{0, 4, 0, 4, 4, 4, 0}, new Object[]{1, 3, 2}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{}, new Object[]{2}, new Object[]{0, 3, 0}, new Object[]{1, 1, 0, 2}}));
        assertEquals(9, getLengthOfMissingArray(new Object[][]{new Object[]{2, 1}, new Object[]{0, 0, 0, 2, 0, 0, 2, 0}, new Object[]{}, new Object[]{0, 1, 3}, new Object[]{4, 1, 4, 0, 3, 3}, new Object[]{2, 2, 4, 1, 2, 1, 0}, new Object[]{0, 3, 3, 2, 4, 1, 2, 0, 2, 4}, new Object[]{3}, new Object[]{3, 4, 2, 0, 2}, new Object[]{2, 0, 3, 2}}));
        assertEquals(4, getLengthOfMissingArray(new Object[][]{new Object[]{4, 4, 3, 4, 3, 3}, new Object[]{1, 1, 2}, new Object[]{4, 1, 4, 1, 2, 0, 2, 3}, new Object[]{3, 1, 4, 3, 0}, new Object[]{0, 3, 1, 2, 0, 4, 4},}));
        assertEquals(0, getLengthOfMissingArray(new Object[][]{new Object[]{1, 4, 4, 1, 1}, new Object[]{0, 1, 3}, new Object[]{}, new Object[]{1, 0}, new Object[]{0, 3, 1, 2, 0, 4, 4},}));
    }
}
