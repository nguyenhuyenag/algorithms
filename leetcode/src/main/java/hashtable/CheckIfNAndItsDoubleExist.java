package hashtable;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int x : arr) {
            // Check if x is double of any previously seen value or vice versa
            if (seen.contains(2 * x) || (x % 2 == 0 && seen.contains(x / 2))) {
                return true;
            }
            seen.add(x);
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true, checkIfExist(new int[]{10, 2, 5, 3}));
        assertEquals(false, checkIfExist(new int[]{3, 1, 7, 11}));
    }

}
