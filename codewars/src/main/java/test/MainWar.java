package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainWar {

    public static boolean isOrthogonal(int[] u, int[] v) {
        if (u.length != v.length) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < u.length; i++) {
            sum += u[i] * v[i];
        }
        return sum == 0;
    }

    @Test
    public void exampleTests() {
        assertEquals(false, isOrthogonal(new int[]{1, 2}, new int[]{2, 1}));
        assertEquals(true, isOrthogonal(new int[]{1, -2}, new int[]{2, 1}));
        assertEquals(false, isOrthogonal(new int[]{7, 8}, new int[]{7, -6}));
        assertEquals(true, isOrthogonal(new int[]{-13, -26}, new int[]{-8, 4}));
        assertEquals(true, isOrthogonal(new int[]{1, 2, 3}, new int[]{0, -3, 2}));
        assertEquals(false, isOrthogonal(new int[]{3, 4, 5}, new int[]{6, 7, -8}));
        assertEquals(true, isOrthogonal(new int[]{3, -4, -5}, new int[]{-4, -3, 0}));
        assertEquals(true, isOrthogonal(new int[]{1, -2, 3, -4}, new int[]{-4, 3, 2, -1}));
        assertEquals(true, isOrthogonal(new int[]{2, 4, 5, 6, 7}, new int[]{-14, -12, 0, 8, 4}));
        assertEquals(false, isOrthogonal(new int[]{5, 10, 1, 20, 2}, new int[]{-2, -20, -1, 10, 5}));
    }

}
