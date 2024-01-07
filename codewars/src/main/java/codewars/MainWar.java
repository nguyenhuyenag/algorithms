package codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class MainWar {

    public static int minimumSteps(int[] numbers, int k) {
        return 1;
    }

    @Test
    public void checkSmallArraySize() {
        doTest(new int[]{4, 6, 3}, 7, 1);
        doTest(new int[]{10, 9, 9, 8}, 17, 1);
    }

    @Test
    public void checkLargerArraySize() {
        doTest(new int[]{8, 9, 4, 2}, 23, 3);
        doTest(new int[]{19, 98, 69, 28, 75, 45, 17, 98, 67}, 464, 8);
    }

    private void doTest(int[] numbers, int k, int expected) {
        assertEquals(expected, minimumSteps(numbers, k));
    }

}
